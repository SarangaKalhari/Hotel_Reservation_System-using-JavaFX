package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {

    private String empID;

    private String name;

    private String role;

    private String phoneNo;

    private String email;

    private double salary;

}