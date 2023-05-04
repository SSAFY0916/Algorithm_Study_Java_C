import java.util.*;
class Solution {
    //RT CF JM AN
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int [] result = new int[4];
        int size = survey.length;
        for(int i=0;i<size;i++){
            if(survey[i].equals("RT")){
                result[0]+=choices[i]-4;
            }else if(survey[i].equals("TR")){
                result[0]=result[0]+8-choices[i]-4;
            }
            else if(survey[i].equals("CF")){
                result[1]+=choices[i]-4;
            }else if(survey[i].equals("FC")){
                result[1]=result[1]+8-choices[i]-4;
            }
            else if(survey[i].equals("JM")){
                result[2]+=choices[i]-4;
            }else if(survey[i].equals("MJ")){
                result[2]=result[2]+8-choices[i]-4;
            }
            else if(survey[i].equals("AN")){
                result[3]+=choices[i]-4;
            }else if(survey[i].equals("NA")){
                result[3]=result[3]+8-choices[i]-4;
            }
        }
        System.out.println(Arrays.toString(result));
        //
        if(result[0]<=0){
            answer+="R";
        }else{
            answer+="T";
        }
        if(result[1]<=0){
            answer+="C";
        }else{
            answer+="F";
        }
        if(result[2]<=0){
            answer+="J";
        }else{
            answer+="M";
        }
        if(result[3]<=0){
            answer+="A";
        }else{
            answer+="N";
        }
        
        return answer;
    }
}