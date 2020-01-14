#include<iostream>
#include<fstream>   
#include<map> 

using namespace std;

string findSum(int arr[], int size , int target) {
    map<int,int> mp;

    for(int i = 0 ; i < size ; i++) {
        int complement = target - arr[i];
        if(mp[complement]) {
            return "1";
        }
        mp[arr[i]] = i+1;        
    }
    return "0";
}

int main() {
    int arr[100000];
    ifstream inp("HashInt.txt");

    int count = 0 , x;
    while(count < 100000 && inp >> x) {
        arr[count++] = x;        
    }

    inp.close();


    int targetSum[9] = {231552, 234756, 596873, 648219, 726312, 981237, 988331, 1277361, 1283379};
    string output = "";

    for(int i = 0 ; i < 9 ; i++) {
        output += findSum(arr, 100000, targetSum[i]);
    }

    cout << output;
}
