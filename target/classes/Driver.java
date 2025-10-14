// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package br.edu.ifpr.cars.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Generated;

@Entity
public class Driver {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   Long id;
   String name;
   LocalDate birthDate;

   @Generated
   public Long getId() {
      return this.id;
   }

   @Generated
   public String getName() {
      return this.name;
   }

   @Generated
   public LocalDate getBirthDate() {
      return this.birthDate;
   }

   @Generated
   public void setId(final Long id) {
      this.id = id;
   }

   @Generated
   public void setName(final String name) {
      this.name = name;
   }

   @Generated
   public void setBirthDate(final LocalDate birthDate) {
      this.birthDate = birthDate;
   }

   @Generated
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof Driver)) {
         return false;
      } else {
         Driver other = (Driver)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            label47: {
               Object this$id = this.getId();
               Object other$id = other.getId();
               if (this$id == null) {
                  if (other$id == null) {
                     break label47;
                  }
               } else if (this$id.equals(other$id)) {
                  break label47;
               }

               return false;
            }

            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null) {
               if (other$name != null) {
                  return false;
               }
            } else if (!this$name.equals(other$name)) {
               return false;
            }

            Object this$birthDate = this.getBirthDate();
            Object other$birthDate = other.getBirthDate();
            if (this$birthDate == null) {
               if (other$birthDate != null) {
                  return false;
               }
            } else if (!this$birthDate.equals(other$birthDate)) {
               return false;
            }

            return true;
         }
      }
   }

   @Generated
   protected boolean canEqual(final Object other) {
      return other instanceof Driver;
   }

   @Generated
   public int hashCode() {
    boolean PRIME = true;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $birthDate = this.getBirthDate();
      result = result * 59 + ($birthDate == null ? 43 : $birthDate.hashCode());
      return result;
   }

   @Generated
   public String toString() {
      String var10000 = String.valueOf(this.getId());
      return "Driver(id=" + var10000 + ", name=" + this.getName() + ", birthDate=" + String.valueOf(this.getBirthDate()) + ")";
   }

   @Generated
   public Driver() {
   }
}
