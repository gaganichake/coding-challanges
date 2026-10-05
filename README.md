# Coding Challenges

A personal collection of algorithmic coding-challenge solutions in Java, gathered from LeetCode, HackerRank, CodeSignal, CTCI ("Cracking the Coding Interview"), and real interview questions. Solutions are organized by **technique/pattern** rather than by source, since recognizing the pattern is the actual skill being practiced.

This README is a running cheat sheet of the patterns, tricks, and gotchas discovered while solving these problems — a distilled "what I learned" companion to the code.

## Repo layout

```
src/main/java/com/codingchallanges/
├── array/
│   ├── binarysearch/   search in sorted / rotated / bitonic arrays
│   ├── histogram/      monotonic-stack area problems
│   ├── interval/       merge / scheduling problems
│   ├── math/           number theory, big numbers, arithmetic tricks
│   ├── matrix/         2D array manipulation
│   ├── search/         linear scan variants
│   ├── sort/           classic sorting algorithms
│   ├── string/         string manipulation
│   └── twopointers/    two-pointer / sliding-window problems
├── bitmanipulation/    XOR / bitwise tricks
├── designing/          OOD / system-design style problems
├── graph/
│   ├── bfs/            shortest path, level-order problems
│   └── dfs/            reachability, cycle, recursive graph problems
├── hashmap/             O(1) lookup, frequency counting, two-sum family
├── hashset/             membership / duplicate detection
├── linkedlist/          pointer manipulation
├── prefixsum/           running-sum & 1D DP problems
├── queue/               queue built from other structures
├── recursion/
│   ├── backtracking/   combinatorial search (subsets, permutations, combinations)
│   ├── dynamicprog/    overlapping-subproblem recursion + memoization
│   └── sequence/       simple recursive sequences
├── stack/               LIFO / matching / monotonic-stack problems
├── tree/
│   ├── binarysearchtree/  BST invariants, self-balancing trees
│   ├── binarytree/        traversal & recursive tree problems
│   ├── heap/               priority queues, running median
│   └── tries/              prefix trees
└── queue, Solution.java, etc.
```

---

## Cheat sheet by category

### Binary Search (`array/binarysearch`)
- **Pattern:** divide-and-conquer on a sorted (or "sorted-ish": rotated, bitonic, interval-blocked) range.
- **`mid = left + (right - left) / 2`**, never `(left + right) / 2` — avoids `int` overflow when `left + right` exceeds `Integer.MAX_VALUE` (see `BinarySearch.java`).
- **Rotated sorted array:** at each step one half (`[left, mid]` or `[mid, right]`) is always internally sorted. Compare `arr[left]` vs `arr[mid]` to decide which half is sorted, then check if the key falls in that half's range before recursing (`BinarySearchRotatedArray.java`). Duplicates break the "always one sorted half" guarantee — handle the `arr[left] == arr[mid]` case by searching both halves.
- **Bitonic array (rises then falls):** first binary-search for the peak (`arr[mid] < arr[mid+1]` → peak is to the right), then run an ascending binary search on the left segment and a descending one on the right (`BitonicArraySearch.java`).
- **Sorted array with empty/sentinel slots:** if `arr[mid]` is the sentinel (`-1` or `""`), scan outward from `mid` with two pointers until a real value is found, then treat that as the new `mid` (`BinarySearchWithEmptyBlocks.java`).
- **Peak-finding loop invariant:** `while (low < high)` with `high = mid` (not `mid - 1`) when the peak could be at `mid` itself — a common off-by-one trap.

### Histogram (`array/histogram`)
- **Pattern:** monotonic increasing stack of bar *indices*. Push while the next bar is taller; on a shorter bar, pop and compute area with the popped bar as the limiting height, using the new stack top (or start/end) as the width boundary.
- **Trick:** width of the rectangle for a popped bar `top` is `i - stack.peek() - 1` (or just `i` if the stack is empty) — this is the single hardest line to get right in this pattern (`LargestRectangleArea.java`).
- After the main loop, drain the remaining stack the same way — the last bars never got a chance to "close."
- Largest-rectangle-in-histogram generalizes to: largest square in a binary matrix, and the "trapping rain water" / `MostWater` family via the same left-max/right-max or monotonic-stack idea.

### Intervals (`array/interval`)
- **Pattern:** sort by start time first, then do a single linear sweep.
- **Merge intervals:** sort, then for each interval, if it overlaps the last merged interval (`last.end >= next.start`) extend the end, otherwise append a new interval (`MergeIntervals.java`).
- **Meeting rooms / resource counting:** either (a) sort start times and end times **separately** and sweep both with two pointers, incrementing a room counter on every start and decrementing when a start ≥ the earliest unfinished end; or (b) reuse the merge-intervals sweep but count "rooms" as intervals that don't get merged (`MeetingRoomsII.java`).
- Watch the overlap boundary: `<` vs `<=` at `interval[start]`/`last[end]` decides whether touching intervals (`[1,4],[4,5]`) count as overlapping — get this from the problem statement, not intuition.

### Two Pointers (`array/twopointers`)
- **Pattern:** two indices moving toward each other (palindrome checks) or in the same direction at different speeds (fast/slow, in-place partition).
- **Palindrome checks:** `low`/`high` converge from both ends; for "ignore non-alphanumeric" variants, use **inner `while` loops to skip** invalid characters on each side before comparing (`Palindrome.java`).
- **In-place partition (move zeroes):** don't "push zeroes to the end" — instead maintain a write-pointer `z` for the next non-zero slot and swap non-zero elements into it as you scan; the zeroes end up at the end as a side effect (`MoveZero.java`).
- **Trapping rain water (brute force):** water at index `i` = `min(maxLeftOf(i), maxRightOf(i)) - height[i]`; the O(n²) version recomputes left/right max per index — the O(n) upgrade is to precompute both max arrays once, or use the converging two-pointer trick tracking a running `leftMax`/`rightMax` (`WaterFallArea.java`).

### Bit Manipulation (`bitmanipulation`)
- **XOR cancels pairs:** `a ^ a = 0` and `a ^ 0 = a`, so XOR-ing an entire array leaves only the element that doesn't have a pair — O(n) time, O(1) space, no hash set needed (`LonleyInteger.java`). The hashset "find odd occurrences" problem (below) is the same idea generalized to *any* odd count, not just exactly 1.

### Hash Map (`hashmap`)
- **Pattern:** trade O(n) space for O(1) average lookup to turn an O(n²) nested-loop search into O(n).
- **Two-sum family:** store `value -> index` in a map, then for each element look up its complement (`target - value`). When multiple valid pairs exist and the problem asks for a specific one (e.g., "the pair whose later element has the smallest index"), collect all valid pairs into a `TreeMap` keyed by that index and take `firstKey()` rather than returning the first match found during the scan (`DuoSumFinder.java`).
- **Subarray sum equals K — prefix sum + hash map combo:** maintain a running `sum` and a map of `prefixSum -> count`; at each step add `map.getOrDefault(sum - k, 0)` to the answer, then record the current sum. Seed the map with `(0, 1)` to correctly count subarrays starting at index 0 (`SubarraySum.java`, also in `prefixsum/`).
- **Cryptarithm / pattern-matching puzzles:** build a `char -> char` (or `char -> int`) substitution map once, then validate every string through it; check leading-zero constraints *after* substitution, not before (`IsCryptSolution.java`).
- **Alien dictionary / custom ordering:** don't sort — just build a `char -> rank` map from the custom alphabet and compare adjacent words character-by-character using the mapped ranks. Remember the "prefix" edge case: if one word is a prefix of the next (`"app"` before `"apple"`), it's valid only if the shorter one comes first (`VerifyAlienDictionary.java`).

### Hash Set (`hashset`)
- **Pattern:** O(1) membership test replaces an O(n) linear scan inside a loop, collapsing O(n²) to O(n).
- **First duplicate:** scan once, add to a `Set` as you go; the first element already in the set when you check it is the answer, because an earlier index is naturally seen first (`FirstDuplicate.java`).
- **Find odd-occurrence elements, elegantly:** instead of counting occurrences, **toggle membership** — add if absent, remove if present. Whatever remains in the set after one pass occurred an odd number of times (`FindOddOccurrances.java`). This is the hashset generalization of the XOR trick above.

### Linked List (`linkedlist`)
- **Fast/slow (tortoise-and-hare) pointer:** advance `slow` by 1 and `fast` by 2. If `fast` (or `fast.next`) hits `null`, there's no cycle; if `fast == slow`, there is one (`HasCycle.java`). The same two-speed idea finds the middle node without knowing the list length — useful for palindrome checks (`IsListPalindrome.java`) and for splitting a list in half.
- **Reversal:** the classic pattern is "peel off the head, re-point it at the already-reversed portion" — keep a `prev`/`temp` pointer and rebuild the list node by node; no extra array needed (`ReverseALinkedList.java`).
- **Reverse in k-groups:** reversing a sub-range needs the node *just past* the group (the `tail`) passed in as a sentinel stop condition, and the previous group's last node needs its `.next` re-pointed to the new sub-head once the reversal returns (`ReverseNodesInKGroups.java`).
- **In-place deletion:** keep an explicit `prev` pointer; only advance `prev` when the current node is *kept* — if the current node is deleted, `prev` stays put so its `.next` can be rewired to skip over it (`RemoveKFromList.java`). Special-case `prev == null` for deletions at the head.
- A dummy/sentinel head node (not used everywhere in this repo, but worth remembering) eliminates the "is this the first node?" branch entirely in insert/delete logic.

### Prefix Sum (`prefixsum`)
- **Pattern:** precompute `prefixSum[i] = prefixSum[i-1] + nums[i-1]` (1-indexed, size `n+1`, `prefixSum[0] = 0`) so any range sum `[i, j]` becomes `prefixSum[j+1] - prefixSum[i]` in O(1) (`SumInRange.java`, `SubarraySum.java`).
- **Modulo arithmetic gotcha:** when summing many range-sums under a modulo, apply `Math.floorMod` to the **running total after every addition**, not just at the end — overflow or negative-modulo bugs otherwise creep in. `Math.floorMod` also correctly handles negative operands, unlike `%` (`SumInRange.java`).
- **House Robber (DP as "prefix max"):** `dp[i] = max(dp[i-2] + nums[i], dp[i-1])` — this is really a prefix-sum-style running optimum, not a true prefix sum, but it's filed here because the recurrence only looks two steps back, same access pattern (`HouseRobber.java`). The naive recursive version is exponential; bottom-up array (or memoized recursion) is O(n).
- **Longest increasing run:** `runLength[i] = array[i] > array[i-1] ? runLength[i-1] + 1 : 0` — track the max and its end index as you go, then slice backward by the run length to recover the actual subsequence (`LongestIncreasingSubsequence.java`). This specific file solves the *contiguous* increasing run, not the classic O(n log n) LIS (non-contiguous) problem — don't confuse the two.

### Stack (`stack`)
- **Pattern:** LIFO matching — push "openers", and on a "closer" check whether it matches `stack.pop()`.
- **Balanced brackets:** map every closing bracket to its expected opener via a small `switch`; an unmatched closer or a non-empty stack at the end both mean "unbalanced" (`BalancedBrackets.java`).
- **Minimum removals to make parentheses valid:** track *indices* to delete in a `Set`, not characters — push `(` indices; on an unmatched `)`, mark that index for deletion; any `(` indices still on the stack at the end are also unmatched and get marked. Build the final string by skipping marked indices (`MakeValidParentheses.java`). An alternative balance-counter approach does the same forward, then does a second reversed pass swapping the roles of `(`/`)` to catch unmatched openers.
- **Monotonic stack** (see Histogram above) is the stack-pattern's other major use case here — not just matching, but maintaining order to answer "nearest greater/smaller" style questions in O(n) total instead of O(n²).

### Queue (`queue`)
- **Queue from two stacks:** keep all elements in `q`; on `push`, pour `q` into a `temp` stack, push the new value onto the now-empty `q`, then pour `temp` back — this keeps the oldest element always on top of `q` for O(1) `peek`/`remove`, at the cost of O(n) `push` (`QueueUsingTwoStacks.java`).

### Recursion → Backtracking (`recursion/backtracking`)
- **Pattern:** build a path incrementally, record it at the decision point, recurse, then **undo the last choice** (`list.remove(list.size()-1)`) before trying the next option — the literal meaning of "backtracking."
- **Subsets:** add the current (possibly incomplete) partial list to the output *at every recursive call*, not just at a base case, since every prefix is itself a valid subset; loop `i` from `start` to avoid generating duplicate/out-of-order subsets (`Subsets.java`).
- **Combination sum (reuse allowed):** recurse with the **same** start index `i` (not `i + 1`) when an element can be reused unlimited times; switch to `i + 1` the moment elements can only be used once (`CombinationSum.java`).
- **Letter combinations of a phone number:** no explicit un-choose step needed when you build strings by concatenation (`String` is immutable) instead of mutating a shared buffer — each recursive call gets its own copy "for free" (`LetterCombinations.java`). Contrast with the `List`-based backtracking above, which *does* need an explicit remove.
- General template referenced throughout this package: loop over choices → add choice → recurse(start/ start+1) → remove choice (undo).

### Recursion → Dynamic Programming (`recursion/dynamicprog`)
- **Pattern:** identify overlapping subproblems in a naive recursion, then cache results (top-down memoization) or build a table bottom-up.
- **Memoization key design:** when the recursive state has more than one changing parameter (e.g., coin-change's `(money, index)`), combine them into a single composite map key (`money + "-" + index`) rather than nesting maps (`MakeChange.java`).
- **Decode Ways:** base cases matter more than the recursive step here — a leading `'0'` makes a substring undecodable (`return 0`), and you only take the two-digit branch when the two-digit number is `<= 26` (`DecodeWays.java`).
- **Grid path counting:** memoize on `(row, col)` with a 2D array sized to the grid; always check the base case (`isValidSquare`, `isAtEnd`) *before* touching the memo table to avoid `ArrayIndexOutOfBounds` (`CountThePath.java`). Note: in this file the memo check happens *after* recursing into both children rather than before — meaning it still visits children redundantly on a cache hit at a child; memoizing immediately after entering the function (not just before returning) avoids this subtle recomputation bug.
- **Fibonacci, the canonical memoization demo:** naive recursion is O(2ⁿ) because `fib(n-2)` gets recomputed from scratch inside both `fib(n-1)` and the outer call; caching collapses it to O(n) (`Fibonacci.java`). Use this file as the "why memoize at all" reference before tackling the harder DP problems above.

### Recursion → Sequence (`recursion/sequence`)
- Pure recursive sequence generation (Fibonacci, Look-and-Say) — the lesson here is mainly "write the base case first, then trust the recursive case," and that naive recursive sequence code is a prime memoization candidate (see Fibonacci above).

### Graph BFS (`graph/bfs`)
- **Pattern: BFS always finds shortest paths in an unweighted graph** — because it visits nodes in non-decreasing distance order, so the *first* time a node is reached is guaranteed to be via a shortest path.
- **Distance array trick:** initialize all distances to `-1` (meaning both "unvisited" and "unreachable" if never updated) instead of using a separate `visited` set — one array serves both purposes (`ShortedDistanceBFS.java`, `QuickestWayUpSnakesAndLadders.java`).
- **Snakes & Ladders:** model the board as a graph where each cell has edges to `cell+1 .. cell+6` (the die roll), **not** edges for the ladders/snakes themselves — a ladder/snake is a *teleport applied after* landing on a cell, otherwise it incorrectly counts as a one-move "free" edge in the shortest-path calculation (`QuickestWayUpSnakesAndLadders.java`).
- Always check "have I already computed this node's distance?" before overwriting it — in BFS that check is simply `distance == -1`, which is cheaper than a `visited.contains()` lookup on a separate set.

### Graph DFS (`graph/dfs`)
- **Pattern:** recurse into neighbors, tracking a `visited` set to avoid infinite loops on cycles.
- DFS is natural for reachability but is explicitly called out in this repo as *not* the right tool for shortest-path — use BFS for that (`HasPathDFS.java` comment).
- **Find-the-celebrity (graph reduction trick):** reframe "who does everyone know, and who knows no one" as: candidate `i` is the celebrity iff for every other `j`, `i` doesn't know `j` AND `j` does know `i`. This turns an apparent O(n²) all-pairs problem into something you can also solve in true O(n) with a two-pointer elimination scan (not shown here, but worth remembering as the follow-up optimization) (`FindACelebrity.java`).

### Tree — Binary Tree (`tree/binarytree`)
- **Pattern:** nearly every problem is "define the answer for a node recursively in terms of the answers for its children," i.e., post-order thinking even when written as straightforward recursion.
- **Balanced tree check:** compare `height(left)` vs `height(right)` at every node, not just the root — a tree can look balanced at the top while being unbalanced three levels down (`IsBalancedTree.java`). Naively recomputing height at every node makes this O(n log n) / O(n²); compute height and the balance check in a single bottom-up pass for O(n) if performance matters.
- **Symmetry check:** symmetry is "mirror equality" between a tree and *itself*, so recurse on `(a.left, b.right)` and `(a.right, b.left)` starting from `isSymmetric(root, root)` — not a plain equality check (`IsSymmetricTree.java`).
- **Level-order traversal (BFS, not DFS, for a tree):** a plain queue gives flat order; to print level-by-level, track each node's level in a side map as you enqueue its children (`level = parentLevel + 1`), and emit a line break whenever the level increments (`TraversalLevelOrder.java`).

### Tree — Binary Search Tree (`tree/binarysearchtree`)
- **Validate BST via in-order traversal:** an in-order traversal of a valid BST visits nodes in strictly increasing order — so it's enough to track the *previously visited value* and fail if the current value isn't larger, instead of threading min/max bounds through every recursive call (`IsBinarySearchTree.java`).
- **Kth smallest, O(1) extra space:** do an **iterative** in-order traversal using an explicit `Stack` (push left-chain, pop, count, descend right) to find the kth element without the O(h) *recursive call stack* counting against your space budget — recursion technically still uses O(h) stack space even though it "feels" like O(1) (`KthSmallestInBST.java`).
- **AVL rebalancing:** after every insert/delete, walk the tree, recompute each node's balance factor (`height(left) - height(right)`), and rotate wherever `|balance| > 1` — rotate-right for left-heavy (`balance < -1`), rotate-left for right-heavy (`balance > 1`) (`AVLTree.java`). Remember: an AVL tree *must* also be a valid BST — a generically height-balanced tree (see `IsBalancedTree.java` above) is a weaker property.

### Tree — Heap (`tree/heap`)
- **Array-backed binary heap index math:** for a node at index `i` (0-based): left child `2i+1`, right child `2i+2`, parent `(i-1)/2`. Memorize this once — it's reused in every array-heap implementation (`MinHeap.java`).
- **heapifyUp / heapifyDown:** insert always goes at the end of the array then **bubbles up** by swapping with its parent while it's smaller (min-heap) than the parent; removal swaps the root with the *last* element, shrinks the array, then **bubbles down**, always swapping with whichever child is smaller to maintain the heap property (`MinHeap.java`).
- **Running median with two heaps:** keep a max-heap for the lower half of the numbers and a min-heap for the upper half, kept balanced in size (differ by ≤ 1); the median is the top of whichever heap is larger, or the average of both tops when they're equal in size. Java's `PriorityQueue` with `Comparator.reverseOrder()` gives you a max-heap "for free" (`TrackMedian.java`).

### Tree — Trie (`tree/tries`)
- **Pattern:** a tree where each edge represents one character; use a `Map<Character, Node>` (not a fixed `char[26]` array) when the alphabet isn't guaranteed to be exactly lowercase a-z — more flexible, slightly more overhead per node (`Tries.java`).
- **Prefix counting:** to count how many words share a prefix, walk the trie to the end of the prefix, then **count all `isEndOfWord` leaves in that subtree** recursively — the trie structure itself already groups all words with a common prefix under one subtree, so this is just a DFS/subtree sum (`Tries.java`'s `countAllLeafNodes`).
- `isEndOfWord` flags are essential: without them, a trie can't tell "cat" was inserted from merely having traversed through the nodes c→a→t while inserting "caterpillar."

### Sorting (`array/sort`)
- **Quick sort partition:** using `left <= right` with two independent `while` scan loops (advance `left` while too small, retreat `right` while too large) and the Hoare partition scheme returns the partition index as `left`, and the recursive calls should be `[left, partitionIndex-1]` and `[partitionIndex, right]` — getting the partition-index boundaries one index off is the single most common quicksort bug (`QuickSort.java`).
- **Radix sort:** sort by one digit (ones, tens, hundreds, ...) at a time using digit-value buckets (`0`-`9`), and because each pass is a *stable* bucket sort, sorting from least-significant to most-significant digit produces a fully sorted array after the last pass — no comparisons between elements at all, O(d·n) instead of O(n log n) (`RadixSort.java`).

### Math (`array/math`)
- **Fast exponentiation (`x^n` in O(log n)):** recursively compute `half = pow(x, n/2)`, then the answer is `half * half` (even `n`) or `half * half * x` (odd `n`) — halves the number of multiplications needed vs. the naive O(n) loop, and handles negative `n` by inverting `x` and negating `n` up front (`Pow.java`).
- **Primality testing:** you only need to check divisors up to `√n`, because if `n = a * b` with both `a, b > √n`, then `a * b > n` — a contradiction. This turns an O(n) check into O(√n) (`IsPrime.java`).

### Matrix (`array/matrix`)
- **In-place 90° rotation:** the destination cell `(i, j)` of the rotated image pulls its value from the source cell `(n-1-j, i)` — one formula replaces four nested loops of "rotate layer by layer" logic (`RotateImage.java`).
- **Spiral generation via "try to move, back off, turn" instead of computed bounds:** keep direction vectors for right/down/left/up in two parallel arrays, advance one step, and only when the next cell is invalid (out of bounds or already filled) back up one step and rotate `direction = (direction + 1) % 4` — much less bug-prone than computing per-layer loop bounds by hand (`SpiralArray.java`).
- **Search a row-and-column sorted matrix:** per-row binary search is a solid O(M log N) baseline; the genuinely different trick (not fully implemented here, but noted as the target) is to start at the top-right or bottom-left corner and eliminate a full row or column per comparison for O(M+N) (`SearchSortedMatrix.java`).

---

## Cross-cutting lessons (apply everywhere)

- **`mid = left + (right - left) / 2`**, always — not `(left + right) / 2`. Shows up in every binary-search variant in this repo.
- **Prefer an array/map of "distance so far" initialized to a sentinel (`-1`) over a separate `visited` `Set`** when you need both "have I seen this" and "what's the value" — one structure, one lookup, in both BFS and heap problems.
- **XOR / Set-toggle tricks turn "count occurrences" problems into single-pass, O(1)-extra-space problems** whenever the question is really about *parity* (exactly one odd-count element, or all odd-count elements) rather than exact counts.
- **Prefix sums turn repeated range-sum queries into O(1) lookups** after an O(n) precompute — reach for this any time you see "sum of a sub-range, queried many times."
- **Backtracking = choose → recurse → un-choose.** The "un-choose" step is easy to forget when the accumulator is a mutable `List`; it's not needed when the accumulator is an immutable `String`, because each call naturally gets its own copy.
- **Memoization key = all the parameters that vary across recursive calls**, combined into one key. Missing a parameter in the key silently causes wrong cache hits across different problem states.
- **In linked lists, draw it on paper before coding.** Almost every bug in this package (`ReverseNodesInKGroups`, `RemoveKFromList`) comes from losing track of which pointer is "the previous node" vs. "the node about to be relinked," especially near the head or tail.
- **Recursion has a hidden O(depth) space cost** even when it "looks" like O(1) extra space — call out the iterative + explicit-stack version whenever a problem explicitly asks for O(1) extra space (see `KthSmallestInBST.java`).