package com.zola.invoice.api.filter;

public class InvoiceFilter {
	private String invoiceNumber;
	private String poNumber;
	private int offset;
	private int limit;

	private InvoiceFilter() {

	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public static class InvoiceFilterBuilder {
		private String invoiceNumber;
		private String poNumber;
		private int offset;
		private int limit;

		public InvoiceFilterBuilder invoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
			return this;
		}

		public InvoiceFilterBuilder poNumber(String poNumber) {
			this.poNumber = poNumber;
			return this;
		}

		public InvoiceFilterBuilder offset(int offset) {
			this.offset = offset;
			return this;
		}

		public InvoiceFilterBuilder limit(int limit) {
			this.limit = limit;
			return this;
		}

		public InvoiceFilter build() {
			InvoiceFilter result = new InvoiceFilter();
			result.setInvoiceNumber(invoiceNumber);
			result.setPoNumber(poNumber);
			result.setOffset(offset);
			result.setLimit(limit);
			return result;
		}
	}
}
