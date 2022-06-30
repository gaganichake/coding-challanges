package com.codingchallanges.designing.objectoriented;

import java.util.*;



/*
 * Credit Karma - Coding challenge 2
 * Nov 17, 2021
 * 
 * A loan has the following data points:
 * 
 * Lender (string)
 * Preapproved (boolean)
 * APR (float)
 * 
 * You’re given a list of loans, a desired page size, and need to paginate them with certain constraints:
 * 
 * Each page has at most pageSize items.
 * A preapproved loan must be the first item on each page if one is available. Preapproved loans cannot show up in any other position other than first. Make new pages if necessary.
 * A lender appears at most once on each page. Make new pages if necessary.
 * Without violating the above constraints, return loans sorted in increasing APR since lower is better.
 * Without violating the above constraints, pages should be maximally compact (return the fewest possible pages).
 */

class Loan implements Comparable<Loan> {
	double apr;
	String lender;
	boolean preApproved;

	public Loan(double apr, String lender, boolean preApproved) {
		this.apr = apr;
		this.lender = lender;
		this.preApproved = preApproved;
	}

	public double getApr() {
		return this.apr;
	}

	public String getLender() {
		return this.lender;
	}

	public boolean getPreApproved() {
		return this.preApproved;
	}

	@Override
	public String toString() {
		return "Loan(" + this.apr + ", " + this.lender + ", " + this.preApproved + ")";
	}

	@Override
	public int compareTo(Loan loan) {

		if (this.preApproved != loan.preApproved)
			return -1;
		else
			return Double.compare(this.apr, loan.apr);

	}

	@Override
	public boolean equals(Object o) {

		Loan loan = o instanceof Loan ? (Loan) o : null;

		return this.lender.equals(loan != null ? loan.lender : null);

	}

	private final static List<Loan> loans = Arrays.asList(new Loan(0.23, "Wells Fargo", false),
			new Loan(0.24, "Wells Fargo", true), new Loan(0.21, "Upstart", false), new Loan(0.19, "LendingTree", false),
			new Loan(0.20, "Upstart", true), new Loan(0.25, "Wells Fargo", true),
			new Loan(0.28, "Bank of America", true), new Loan(0.29, "Wells Fargo", false),
			new Loan(0.31, "Wells Fargo", false));

	private final static List<List<Loan>> correctPagingFor3LoansPerPage = Arrays.asList(
			Arrays.asList(new Loan(0.20, "Upstart", true), new Loan(0.19, "LendingTree", false),
					new Loan(0.23, "Wells Fargo", false)),
			Arrays.asList(new Loan(0.24, "Wells Fargo", true), new Loan(0.21, "Upstart", false)),
			Collections.singletonList(new Loan(0.25, "Wells Fargo", true)),
			Arrays.asList(new Loan(0.28, "Bank of America", true), new Loan(0.29, "Wells Fargo", false)),
			Collections.singletonList(new Loan(0.31, "Wells Fargo", false)));

	// Returns a list of pages of loans, subject to the following constraints:
	// * Each page has at most `pageSize` items.
	// * A preapproved loan must be the first item on each page if one
	// is available. Preapproved loans cannot show up in any other position other
	// than first. Make new pages if necessary.
	// * A lender appears at most once on each page. Make new pages if necessary.
	// * Without violating the above constraints, return loans sorted in increasing
	// APR since lower is better.
	public static List<List<Loan>> getPages(List<Loan> loans, int pageSize) {

		// Collections.sort(loans);

		List<List<Loan>> pages = new ArrayList<>();

		List<Loan> approvedLoans = new ArrayList<>();

		List<Loan> unapprovedLoans = new ArrayList<>();

		for (Loan loan : loans) {

			if (loan.preApproved) {
				approvedLoans.add(loan);
			} else {
				unapprovedLoans.add(loan);
			}
		}

		Collections.sort(approvedLoans);

		Collections.sort(unapprovedLoans);

		for (Loan approvedLoan : approvedLoans) {

			List<Loan> page = new ArrayList<>();
			if (0 < pageSize) {
				page.add(approvedLoan);
			}

			Iterator<Loan> iterator = unapprovedLoans.iterator();

			while (iterator.hasNext()) {

				Loan unapprovedLoan = iterator.next();

				if (!page.contains(unapprovedLoan) && page.size() < pageSize) {
					page.add(unapprovedLoan);
					iterator.remove();
				}
			}

			pages.add(page);
		}

		List<Loan> lastPage = new ArrayList<>();

		for (Loan unapprovedLoan : unapprovedLoans) {

			if (!lastPage.contains(unapprovedLoan) && lastPage.size() < pageSize) {
				lastPage.add(unapprovedLoan);
			}
		}

		pages.add(lastPage);

		return pages;
	}

	public static void main(String[] args) {
		for (List<Loan> page : getPages(loans, 3)) {
			for (Loan loan : page) {
				System.out.println(loan.toString());
			}
			System.out.println();
		}
	}

}
