package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.student.student_participation.scholarship_participation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BankAccountType {
    CURRENT_ACCOUNT("Conta corrente"),
    SAVINGS_ACCOUNT("Conta poupança");

    private final String name;
}
