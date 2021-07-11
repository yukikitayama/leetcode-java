import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution609 {
    public List<List<String>> findDuplicate(String[] paths) {
        // Key: Contents, Value: Paths
        HashMap<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] values = path.split(" ");

            // values[0] is a path excluding filename, so skip it
            for (int i = 1; i < values.length; i++) {

                // In Java ( is a metacharacter, so we need to escape it by backslash. In String, we need to double
                // backslashes
                // filename_content[0]: filename, filename_content[1]: content
                String[] filename_content = values[i].split("\\(");

                // Clean content
                filename_content[1] = filename_content[1].replace(")", "");

//                for (String tmp : filename_content) {
//                    System.out.print(tmp + ", ");
//                }
//                System.out.println();

                // Update path list
                List<String> path_list = map.getOrDefault(filename_content[1], new ArrayList<String>());
                String complete_path = values[0] + "/" + filename_content[0];
                path_list.add(complete_path);
                map.put(filename_content[1], path_list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (String content : map.keySet()) {
            // Duplicate
            if (map.get(content).size() > 1) {
                ans.add(map.get(content));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution609 sol = new Solution609();
        String[] test = {
                "root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)","root 4.txt(efgh)"
        };
        List<List<String>> answer = sol.findDuplicate(test);
        System.out.println(answer);
    }
}
