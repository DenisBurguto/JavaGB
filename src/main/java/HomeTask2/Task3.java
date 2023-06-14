package HomeTask2;

public class Task3 {
    public static void main(String[] args) {
        String[] jsonStringArray = {"{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}",
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}",
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}"};
        for (int i = 0; i < jsonStringArray.length; i++) {

            String[] jsonLine = jsonStringArray[i].replaceAll("\\{", "").replaceAll("}", "")
                    .replaceAll("\"", "").replaceAll(" ", "").replaceAll(":", ",").split(",");
            StringBuilder outLine = new StringBuilder();
            for (int j = 1; j < 2; j++) {

                outLine.append("Студент ")
                        .append(jsonLine[j])
                        .append(" получил ")
                        .append(jsonLine[j + 2])
                        .append(" по предмету ")
                        .append(jsonLine[j + 4])
                        .append(".");

            }
            System.out.println(outLine);

        }

    }

}
