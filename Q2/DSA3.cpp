#include <iostream>
#include <stdlib.h>
#include <string.h>
using namespace std;

//Creating the job structure array
struct job{
	string jobid;
	int deadline;
	int profit;
};
 

//Compae the value with the maximum dead line level
int min(int x,int y ){
		if(x<=y){
		//	printf("%d",x);
		//cout << x;
   			return x;
		}else{
		//	printf("%d",y);
		//cout << y;
			return y;
		}
}

int main(){
	int i,j;
	job temp;
	int max_deadlinelevel=0;
	int slot[max_deadlinelevel];
	
	//Initializing the value to the array
	job jobs[]={{"J1",2,90},{"J2",2,20},{"J3",1,40},{"J4",1,30},{"J5",4,65},{"J6",1,35},{"J7",3,50}};
	int n=sizeof(jobs)/sizeof(jobs[0]);
	//cout << "Number of jobs available";
	//cout << n;
	printf("Number of jobs avaiable:%d\n",n);
	
	//Sorted the Jobs Id according to the decending order of the profit
	for(i=1;i<n;i++){
		for(j=0;j<n-i;j++){
			if(jobs[j+1].profit>jobs[j].profit){
				temp=jobs[j+1];
				jobs[j+1]=jobs[j];
				jobs[j]=temp;
			}
		}
	
	}

	for(i=0;i<n;i++){
		//Print the sortde jobs in decending Order
		printf("JobID %s Profit %d Deadline %d \n",jobs[i].jobid.c_str(),jobs[i].profit,jobs[i].deadline);
		//Find the maximum deadline level
		if(jobs[i].deadline>max_deadlinelevel){
			max_deadlinelevel=jobs[i].deadline;
		}
	}
	//Print the maximum deadline level 
	printf("Maximum Deadline : %d\n",max_deadlinelevel);
	
	//Creating empty slot according to the number of maximum deadline level
	for (int i=0; i<=max_deadlinelevel; i++) {
        slot[i] = false; 
    }
    
    
    //Compare with the maximum deadline level and if it below the maximum ,put the value in to the  slot,When the slot is empty.
    for(i=0;i<n;i++){
    	int val;
    	val=min( max_deadlinelevel ,jobs[i].deadline);
    //printf("%d",val);
		while(val>=0){
			if(slot[val]==false){
				slot[val]=i;
				break;
					
			}
			val--;
			
		}
		//printf("***%d",val);
		
   
	}
	
	printf("Following is maximum profit sequence of jobs: \n");
	//print the jobid
	for(i=1;i<=max_deadlinelevel;i++){
//		printf("%d",i);
		printf(" %s ",jobs[slot[i]].jobid.c_str());
	}
  
}
