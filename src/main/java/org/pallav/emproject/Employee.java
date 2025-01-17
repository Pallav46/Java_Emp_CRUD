package org.pallav.emproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String phone;
    private String email;

    // public String getName() {
    //     return name;
    // }

    // public String getPhone() {
    //     return phone;
    // }

    // public String getEmail() {
    //     return email;
    // }

    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setPhone(String phone) {
    //     this.phone = phone;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

}
