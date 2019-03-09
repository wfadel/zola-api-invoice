package com.zola.invoice.api.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class InvoiceDto implements Serializable {
	private static final long serialVersionUID = 3040125111929707622L;

	private Integer id;
	private String invoiceNumber;
	private String poNumber;
	private LocalDate dueDate;
	private Long amountCents;
	private LocalDateTime createdAt;

	private InvoiceDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Long getAmountCents() {
		return amountCents;
	}

	public void setAmountCents(Long amountCents) {
		this.amountCents = amountCents;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceDto other = (InvoiceDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static class InvoiceDtoBuilder {
		private Integer id;
		private String invoiceNumber;
		private String poNumber;
		private LocalDate dueDate;
		private Long amountCents;
		private LocalDateTime createdAt;

		public InvoiceDtoBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public InvoiceDtoBuilder invoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
			return this;
		}

		public InvoiceDtoBuilder poNumber(String poNumber) {
			this.poNumber = poNumber;
			return this;
		}

		public InvoiceDtoBuilder dueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
			return this;
		}

		public InvoiceDtoBuilder amountCents(Long amountCents) {
			this.amountCents = amountCents;
			return this;
		}

		public InvoiceDtoBuilder createdAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public InvoiceDto build() {
			InvoiceDto result = new InvoiceDto();
			result.setId(id);
			result.setInvoiceNumber(invoiceNumber);
			result.setPoNumber(poNumber);
			result.setDueDate(dueDate);
			result.setAmountCents(amountCents);
			result.setCreatedAt(createdAt);
			return result;
		}
	}
}
