package com.zola.invoice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.repository.Invoice;

@Component
public class InvoiceDtoToInvoiceConverter implements Converter<InvoiceDto, Invoice> {

	@Override
	public Invoice convert(InvoiceDto invoiceDto) {
		return new Invoice.InvoiceBuilder().invoiceNumber(invoiceDto.getInvoiceNumber())
				.poNumber(invoiceDto.getPoNumber()).dueDate(invoiceDto.getDueDate())
				.amountCents(invoiceDto.getAmountCents()).build();
	}

}
