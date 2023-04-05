import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.*)\\].*");
    private static final Pattern REGEX_ATRIBUTES_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    public List<Map<String, String>> parse(String json){
        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Itens not found.");
        }

        String[] items = matcher.group(1).split("\\},\\{");
        List<Map<String, String>> datas = new ArrayList<>();
        for (String item : items) {
            Map<String, String> atributosItem = new HashMap <>();

            Matcher matcherAtributesJson = REGEX_ATRIBUTES_JSON.matcher(item);
            while (matcherAtributesJson.find()) {
                String atribute = matcherAtributesJson.group(1);
                String value = matcherAtributesJson.group(2);
                atributosItem.put(atribute, value);
            }

            datas.add(atributosItem);
        }

        return datas;
    }
}
