package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.termination;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TerminationTermData {
    String projectTitle;
    String coordinatorName;
    String coordinatorId;    
    String studentName;
    String studentId;
    LocalDate terminationDate;
    String newStudentName;
    String newStudentId;
    LocalDate newStudentStartDate;
    LocalDate date;
    Boolean volunteer;
    String motive;
}
