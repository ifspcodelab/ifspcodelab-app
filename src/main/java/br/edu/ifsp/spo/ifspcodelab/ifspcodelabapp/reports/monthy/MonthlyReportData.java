package br.edu.ifsp.spo.ifspcodelab.ifspcodelabapp.reports.monthy;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@Getter
@AllArgsConstructor
public class MonthlyReportData {
    String projectTitle;
    String coordinatorName;
    String studentName;
    LocalDate date;
    String planActivities;
    String executedActivities;
    String results;
    Boolean volunteer;
}