#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    map<char, int> match;
    match.insert({'R', 0});
    match.insert({'T', 1});
    match.insert({'C', 2});
    match.insert({'F', 3});
    match.insert({'J', 4});
    match.insert({'M', 5});
    match.insert({'A', 6});
    match.insert({'N', 7});
    
    char type[8] = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
    int score[8] = {0, };
    
    int s = survey.size();
    for(int i = 0; i < s; i++) {
        if(choices[i] == 4) continue;
        if(choices[i] < 4) {
            char c = survey[i][0];
            score[match[c]] += 4 - choices[i];
        } else {
            char c = survey[i][1];
            score[match[c]] += choices[i] - 4;
        }
    }
    
    string answer = "";
    for(int i = 0; i < 4; i++) {
        answer += (score[i * 2] >= score[i * 2 + 1]) ? type[i * 2] : type[i * 2 + 1];
    }

    return answer;
}
