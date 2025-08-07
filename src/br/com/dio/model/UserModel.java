package br.com.dio.model;

import java.time.OffsetDateTime;
import java.util.Objects;

public class UserModel {
    private long id;
    private String nome;
    private String email;
    private OffsetDateTime birthday;

    public UserModel(long id, String nome, String email, OffsetDateTime birthday) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.birthday = birthday;
    }

    public UserModel() {
    }

    public long getId() {
        return id;
    }

    public UserModel setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public UserModel setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public UserModel setBirthday(OffsetDateTime birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return id == userModel.id &&
                Objects.equals(nome, userModel.nome) &&
                Objects.equals(email, userModel.email) &&
                Objects.equals(birthday, userModel.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, birthday);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
