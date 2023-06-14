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


            outLine.append("Студент ")
                    .append(jsonLine[1])
                    .append(" получил ")
                    .append(jsonLine[3])
                    .append(" по предмету ")
                    .append(jsonLine[5])
                    .append(".");


            System.out.println(outLine);

        }

    }

}
