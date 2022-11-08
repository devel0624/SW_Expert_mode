import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        Map<Integer, Integer> result = new HashMap<>();

        for(int i = 0 ; i < testCase; i++){

            Map<Integer,Integer> scores = new HashMap<>();

            int caseNum = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()){
                int score = Integer.parseInt(st.nextToken());

                int mode = result.getOrDefault(i,0);

                scores.put(score,scores.getOrDefault(score,1) + 1);

            }

            AtomicInteger mode  = new AtomicInteger(-1);

            scores.forEach(
                    (key,value) -> {
                        if((!scores.containsKey(mode.get())) || scores.get(mode.get()) <= value){
                            mode.set(key);
                        }
                    });
            result.put(caseNum,mode.get());
        }

        result.forEach(
                (key,value) -> System.out.printf("#%d %d\n",key,value)
        );
    }
}