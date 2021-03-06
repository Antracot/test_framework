package com.softserveinc.edu.ita.domains;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Class for setting row fields from the "Administration" table in OMS.
 */
public class AdministrationsTableRow {
    @Getter @Setter(AccessLevel.PRIVATE) private String firstName;
    @Getter @Setter(AccessLevel.PRIVATE) private String lastName;
    @Getter @Setter(AccessLevel.PRIVATE) private String login;
    @Getter @Setter(AccessLevel.PRIVATE) private String role;
    @Getter @Setter(AccessLevel.PRIVATE) private String region;

    public AdministrationsTableRow(final String firstName) {
        this.firstName = firstName.toLowerCase();
    }

    @Override
    public String toString() {
        return "AdministrationsTableRow{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    private AdministrationsTableRow() {
    }

    public static FirstNameStep newBuilder() {
        return new Steps();
    }

    public interface FirstNameStep {
        LastNameStep setFirstName(String firstName);
    }

    public interface LastNameStep {
        LoginStep setLastName(String lastName);
    }

    public interface LoginStep {
        RoleStep setLogin(String login);
    }

    public interface RoleStep {
        RegionStep setRole(String role);
    }

    public interface RegionStep {
        BuildStep setRegion(String region);
    }

    public interface BuildStep {
        AdministrationsTableRow build();
    }

    private static class Steps implements FirstNameStep, LastNameStep, LoginStep, RoleStep, RegionStep, BuildStep {
        private String firstName;
        private String lastName;
        private String login;
        private String role;
        private String region;

        public LastNameStep setFirstName(final String firstName) {
            this.firstName = firstName.toLowerCase();
            return this;
        }

        public LoginStep setLastName(final String lastName) {
            this.lastName = lastName.toLowerCase();
            return this;
        }

        public RoleStep setLogin(final String login) {
            this.login = login.toLowerCase();
            return this;
        }

        public RegionStep setRole(final String role) {
            this.role = role.toLowerCase();
            return this;
        }

        public BuildStep setRegion(final String region) {
            this.region = region.toLowerCase();
            return this;
        }

        public AdministrationsTableRow build() {
            final AdministrationsTableRow administrationsTableRow = new AdministrationsTableRow(firstName);
            if (lastName != null) {
                administrationsTableRow.setLastName(lastName);
            } else {
                administrationsTableRow.setLastName("");
            }
            if (login != null) {
                administrationsTableRow.setLogin(login);
            } else {
                administrationsTableRow.setLogin("");
            }
            if (role != null) {
                administrationsTableRow.setRole(role);
            } else {
                administrationsTableRow.setRole("");
            }
            if (region != null) {
                administrationsTableRow.setRegion(region);
            } else {
                administrationsTableRow.setRegion("");
            }
            return administrationsTableRow;
        }
    }
}
