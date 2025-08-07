import br.com.dio.dao.UserDAO;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static br.com.dio.model.MenuOption.*;

public class Main {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo ao cadastro de usuários selecione a operação desejada");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Buscar o identificador");
        System.out.println("5 - Listar");
        System.out.println("6 - Sair");
        var userInput = scanner.nextInt();
        while (true) {
            var selectedOption = values()[userInput - 1];
            switch (selectedOption) {

                case SAVE -> {
                    var user = dao.save(requestUserSave());
                    System.out.printf("Usuário Cadastrado %s%n", user);
                }
                case UPDATE -> {
                    var user = requestUserUpdate();
                    dao.update(user);
                    System.out.printf("Usuário Atualizado %s%n", user);
                }
                case DELETE -> {
                    dao.delete(requestId());
                    System.out.println("Usuário excluído ");
                }
                case FIND_BY_ID -> {
                    var id = requestId();
                    var user = dao.findById(id);
                    System.out.printf("Usuário com id %s: %s%n", id, user);
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários cadastrados");
                    System.out.println("======================");
                    users.forEach(System.out::println);
                    System.out.println("===========fim===========");
                }
                case EXIT -> System.exit(0);
            }
            System.out.println("Selecione a operação desejada");
            userInput = scanner.nextInt();
        }
    }

    private static long requestId() {
        System.out.println("Informe o identificador do usuário");
        return scanner.nextLong();
    }

    private static UserModel requestUserSave() {
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();
        System.out.println("Informe o e-mail do usuário");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var localDate = LocalDate.parse(birthdayString, formatter);
        var birthday = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        return new UserModel(0, name, email, birthday);
    }

    private static UserModel requestUserUpdate() {
        System.out.println("Informe o identificador do usuário");
        var id = scanner.nextLong();
        System.out.println("Informe o nome do usuário");
        var name = scanner.next();
        System.out.println("Informe o e-mail do usuário");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário (dd/MM/yyyy)");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var localDate = LocalDate.parse(birthdayString, formatter);
        var birthday = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        return new UserModel(id, name, email, birthday);
    }
}
