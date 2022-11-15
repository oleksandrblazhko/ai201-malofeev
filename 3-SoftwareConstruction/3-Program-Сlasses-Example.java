/*
 * This file represents planty of merged .java programm files available by the [link](https://drive.google.com/drive/folders/1zOPnPmkSaGPDa4gDe7Ejf_KCQFnMAbQV?usp=sharing).
 */
 
 package com.nuop.tscp.model.material;

import com.nuop.tscp.model.sculpture.Sculpture;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "material")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "material_id")
  private Long id;

  private String name;

  @ManyToMany(mappedBy = "material")
  private Set<Sculpture> sculpture;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Material material = (Material) o;
    return Objects.equals(id, material.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void addSculpture(Sculpture sculpture) {
    this.sculpture.add(sculpture);
  }
}

package com.nuop.tscp.model.sculpture;

import com.nuop.tscp.model.material.Material;
import com.nuop.tscp.model.sculpture_type.SculptureType;
import com.nuop.tscp.model.user.User;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sculptures")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sculpture {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sculpture_id")
  private Long id;

  private String name;
  private String description;
  private Double cost;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private SculptureType sculptureType;

  @ManyToOne
  @JoinColumn(name = "author_id", insertable = false, updatable = false)
  private User author;

  @ManyToMany
  @JoinTable(name = "sculpture_materials",
    joinColumns = @JoinColumn(name = "sculpture_id"),
    inverseJoinColumns = @JoinColumn(name = "material_id"))
  private Set<Material> materials;

  @ManyToMany
  @JoinTable(name = "sculpture_users",
      joinColumns = @JoinColumn(name = "sculpture_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sculpture that = (Sculpture) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void addMaterial(Material material) {
    materials.add(material);
  }

  public void addUser(User user) {
    users.add(user);
  }
}

package com.nuop.tscp.model.sculpture_type;

import com.nuop.tscp.model.sculpture.Sculpture;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sculpture_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SculptureType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sculpture_type_id")
  private Long id;

  @Column(unique = true)
  private String name;

  @OneToMany(mappedBy = "sculptureType")
  private Set<Sculpture> sculpture;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SculptureType that = (SculptureType) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void addSculpture(Sculpture sculpture) {
    this.sculpture.add(sculpture);
  }
}

package com.nuop.tscp.model.user;

import com.nuop.tscp.model.sculpture.Sculpture;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  private String role;
  private String name;
  private String surname;
  private String patronymic;

  private Double balance = 0D;

  @Column(unique = true)
  private String email;

  @Column(unique = true)
  private String mobile;

  @ManyToMany(mappedBy = "users")
  Set<Sculpture> sculpture = new HashSet<>();

  @OneToMany(mappedBy = "author")
  private Set<Sculpture> ownSculpture = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public void addSculpture(Sculpture sculpture) {
    this.sculpture.add(sculpture);
  }

  public void addOwnSculpture(Sculpture sculpture) {
    ownSculpture.add(sculpture);
  }
}
