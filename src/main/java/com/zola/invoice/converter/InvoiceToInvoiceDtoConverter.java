package com.zola.invoice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.api.dto.InvoiceDto.InvoiceDtoBuilder;
import com.zola.invoice.repository.Invoice;

@Component
public class InvoiceToInvoiceDtoConverter implements Converter<Invoice, InvoiceDto> {

	@Override
	public InvoiceDto convert(Invoice invoice) {
		return new InvoiceDtoBuilder().id(invoice.getId()).invoiceNumber(invoice.getInvoiceNumber())
				.poNumber(invoice.getPoNumber()).dueDate(invoice.getDueDate()).amountCents(invoice.getAmountCents())
				.createdAt(invoice.getCreatedAt()).build();
	}

}
