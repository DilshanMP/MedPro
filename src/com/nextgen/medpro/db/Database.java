package com.nextgen.medpro.db;

import com.nextgen.medpro.dot.DoctorDto;
import com.nextgen.medpro.enums.GenderType;

import java.util.ArrayList;

public class Database {
    public static ArrayList<DoctorDto> doctorTable =
            new ArrayList<>();

    static {
        doctorTable.add(
                new DoctorDto(
                        "pasindu",
                        "dilshan",
                        "9235",
                        "+1254",
                        "p@.com",
                        "Sample 1",
                        "Colombo",
                        GenderType.MALE
                )
        );
    }
}
