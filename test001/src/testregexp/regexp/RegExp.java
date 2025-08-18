package testregexp.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
练习正则 匹配url
 */
public class RegExp {
    public static void main(String[] args) {
        String content = "http://edu.3dsmax.tech/yg/bilibili/my6652/pc/qg/05-51/index.html#201211-1?track_id=jMc0jn-hm-yHrNfVad37YdhOUh41XYmjlss9zocM26gspY5ArwWuxb4wYWpmh2Q7GzR7doU0wLkViEhUlO1qNtukyAgake2jG1bTd23lR57XzV83E9bAXWkStcAh4j9Dz7a87ThGlqgdCZ2zpQy33a0SVNMfmJLSNnDzJ71TU68Rc-3PKE7VA3kYzjk4RrKU";
        /*
        思路：
        1，先确定url的开始部分http:// | https://
        2，通过 ([\w-]+\.)+[\w-]+匹配域名
        3，匹配余下的信息 (\/[\w-?=&/%.#]*)?$
         */
        String regStr = "^((http|https)://)([\\w-]+\\.)+[\\w-]+(\\/[\\w-?=&/%.#]*)?$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println("满足格式");
        }else {
            System.out.println("不满足格式");
        }
    }
}
