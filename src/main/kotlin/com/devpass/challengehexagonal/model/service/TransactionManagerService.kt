package com.devpass.challengehexagonal.model.service

import com.devpass.challengehexagonal.controller.dto.TransactionRequestDto
import com.devpass.challengehexagonal.model.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class TransactionManagerService(
    private val clientRepository: ClientRepository
) {

    fun process(transactionRequestDto: TransactionRequestDto) {
        clientRepository.getClientById(transactionRequestDto.clientId)
            .apply {
                this.balance -= transactionRequestDto.amount
                this.transactions.add(transactionRequestDto.toTransaction())
                clientRepository.saveClient(this)
            }
    }
}