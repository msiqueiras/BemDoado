package util;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EntradaUtils {

    public static LocalDate lerData(Scanner scanner) {
        // Formatador para a data de nascimento
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            try {

            System.out.print("Data de Nascimento (dd/mm/aaaa): ");
            
            return LocalDate.parse(scanner.nextLine(), formatadorData);

            } catch (DateTimeParseException e) {
                System.out.println("❌ Erro: Data inválida. Tente novamente.");
            }
        }
    }

    

}
