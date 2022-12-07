package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.closure;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClosureTermData {
    String projectTitle;
    String coordinatorName;
    String studentName;
    String studentId;
    LocalDate closureDate;
    LocalDate termDate;
    String reason;
    Boolean volunteer;
}
