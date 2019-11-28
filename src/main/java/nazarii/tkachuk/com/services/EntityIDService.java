package nazarii.tkachuk.com.services;

public class EntityIDService {

    public String parseDate(String date) {
        return date.replace("T", " ") + ":00";
    }
}
