package HomeTask2;

import java.util.Objects;

public class TaskOne {
    public static void main(String[] args) {
        String jsonParams = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        StringBuilder whereClause = new StringBuilder("WHERE ");
        jsonParams = jsonParams.replaceAll("\\{", "").replaceAll("}", "")
                .replaceAll("\"", "").replaceAll(" ", "").replaceAll(":", ",");
        String[] parameters = jsonParams.split(",");

        for (int i = 0; i < parameters.length - 1; i += 2) {

            if (Objects.equals(parameters[i + 1], "null")) {
                continue;
            } else {
                whereClause.append(parameters[i]).append(" = '").append(parameters[i + 1]).append("' AND ");

            }
        }
        whereClause.delete(whereClause.length() - 5, whereClause.length());
        System.out.println(whereClause);
    }
}
