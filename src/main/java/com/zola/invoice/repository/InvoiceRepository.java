package com.zola.invoice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends ZolaRepository<Invoice, Long> {
	Page<Invoice> findByInvoiceNumberOrPoNumber(String invoiceNumber, String inoiceName, Pageable pageable);
}
