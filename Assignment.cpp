#include<iostream>
#include<string>

using namespace std ;

struct chemical{
	int location ;
	string element ;
	string name ;
	chemical* next ;
};

int slots = 100 ;
int count = 0 ;
chemical* hashTable[37]= {NULL};  
	
int toHashValue(string);
int insertToList(string,string);
void insertElements();
void searchElements();
void loop ();
void view();

int main(){
	int key ;
	std::cout << std::endl << "Enter number of slots for the hash table : ";
	std::cin >> slots ; 
	
	key = insertToList("Ca","Calsium");
	cout << "Element Ca stored in location " << key << endl ;
	key = insertToList("He","Helium");
	cout << "Element He stored in location " << key << endl ;
	key = insertToList("Na","Sodium");
	cout << "Element Na stored in location " << key << endl ;
	
	loop();

    return 0 ;
}

void loop(){
    std::cout << std::endl << "-------------------------------------------------------------------------" << std::endl ;
    std::cout << std::endl << "Total number of elements stored in the table : " << count << std::endl ;

	string flag ;
	std::cout << std::endl << "To add elements : press a " << std::endl << "To search elements : press b " << std::endl << "To view table : press c " << std::endl << "Answer :" ;
	std::cin >> flag;
	
	if(flag.compare("a")==0){ insertElements();}
	else if(flag.compare("b")==0){searchElements();}
    else if(flag.compare("c")==0){view();}
    

    if(flag.compare("a")==0 || flag.compare("b")==0){
        std::cout << "To run the loop again : press r " << std::endl << "Or any to exit :" << std::endl ;
	    std::cin >> flag;
        if(flag.compare("r")==0){loop();}    
	}
}

void insertElements(){	
	string ele ;
	string name ;

	std::cout << std::endl << "Enter element :" ;
	std::cin >> ele ;
	std::cout << "Enter name :" ;
	std::cin >> name ;
	int res = insertToList(ele,name);
	if(res==-1){
		std::cout << "Hash Table Overflow!" << std::endl ;
	}
	else{
		std::cout << "Element " << name << " stored in location " << res << std::endl ;	
	} 
	
	string flag;
	std::cout << "Do you want to insert again (press y to yes or nay to no) ?" << std::endl ;
	std::cin >> flag;
	if(flag.compare("y")==0){
		insertElements();
	}
}

int insertToList(string ele,string name){
	int key = toHashValue(ele);
	int pos = key%slots ;
	chemical* newChem = (chemical*)malloc(sizeof(chemical));
	
	newChem->location = pos ;
	newChem->element = ele ;
	newChem->name = name ;
	
	if(hashTable[pos]==NULL){
		hashTable[pos]=newChem ;
		count++ ;
        return newChem->location ;
	}
	else{
		pos = (key + (1*1))%slots;
		if(hashTable[pos]==NULL){
			hashTable[pos]=newChem ;
			count++ ;
			return newChem->location ;
		}
		else{
			pos = (key + (2*2))%slots;
			if(hashTable[pos]==NULL){
				hashTable[pos]=newChem ;
				return newChem->location ;
			}
			else {
				return -1 ;
			}	
		}
	}
}

int toHashValue(string Word){

    int hashCode =0 , coefficient = 0 , intBinary = 0;
	string binaryVal, finalVal ; 
 
    //Taking ASCII Value
    for(int i=0;i<Word.size();i++){
	    hashCode += Word[i];
		if(i==Word.size()-1){
			coefficient = Word[i];
		}
	}

    //To Binary Conversion
    int temp = coefficient ;
	while(coefficient>1){
		intBinary = coefficient%2 ;
		coefficient = coefficient/2 ;
		finalVal=to_string(intBinary).append(finalVal);
	}
    finalVal = to_string(coefficient).append(finalVal);		
    
    //Taking last 3 digits
	string lastDigits ;
    string f ;
	for(int i=finalVal.size()-3;i<finalVal.size();i++){
		f = finalVal[i];
        lastDigits.append(f);
	}
	
    //Covert in to integer
    int binary = stoi(lastDigits);
    
    //Convert the binary in to Decimal
    int base = 1 ,decimal=0 , x; 
    while (binary){ 
        int x = binary % 10; 
        binary = binary/10; 
        decimal += x*base; 
        base = base * 2; 
    } 
    
    //Finally return the decimal as the hashcode
    return decimal ;
}

void searchElements(){
	string ele ;
	int pos ;

	std::cout << std::endl << "Enter element to be searched" ;
	std::cin >> ele;
	
	int key = toHashValue(ele);
	pos = key%slots ;
	if(hashTable[pos]==NULL){
		std::cout << "Element not found !" << std::endl ;
	}
	else if((hashTable[pos]->element).compare(ele)==0){
		std::cout << "Element " << ele << " Found at position : " << pos << std::endl ;
	}
	else{
		pos = (key + (1*1))%slots;
		if(hashTable[pos]==NULL){
			std::cout << "Element not found!" << std::endl ;
		}
		else if((hashTable[pos]->element).compare(ele)==0){
			std::cout << "Element " << ele << " Found at position : " << pos << std::endl ;
		}
		else{
		    pos = (key + (2*2))%slots;
        	if(hashTable[pos]==NULL){
				std::cout << "Element not found !" << std::endl ;
			}
			else if((hashTable[pos]->element).compare(ele)==0){
				std::cout << "Element " << ele << " Found at position : " << pos << std::endl ;		
			}	
		}
	}
	string flag;
	std::cout << "Do you want to search again? (press y to yes or nay to no) :" ;
	std::cin >> flag;
	if(flag.compare("y")==0){searchElements();}
}

void view(){
    std::cout << std::endl << "Created Hash Table" << std::endl ;
    for(int i=0;i<slots;i++){
        if(hashTable[i]==NULL){
            std::cout << i << " : " << " NULL " << std::endl ;
        } 
        else{
            std::cout << i << " : " << hashTable[i]->element << " -> " << hashTable[i]->name << std::endl ;
        }
    }
    loop();
}
