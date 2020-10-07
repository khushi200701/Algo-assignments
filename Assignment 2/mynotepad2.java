#include<stdio.h>            
#include<string.h>                             
#include<stdlib.h>                             


struct dll                    
{ 
char s[200];                             
int cursor; 
struct dll *prev,*next;            
}; 
 
void addline(struct dll *temp); 
void inp(void); 
void printlist(void); 
void closer(void); 
void addnode(char t[],struct dll *q); 
void delnode(struct dll *p); 
 
struct dll *head;                        //header node  
char file[20]; 
 
FILE *fp=NULL;                            //file pointer  
 
void main() 
{ 
char c; 
 
head=(struct dll*)malloc(sizeof(struct dll));            
(head->next)=(head->prev)=NULL;                
(head->cursor)=0; 
 
while(1)                 
{ 
 
system("clear");                         
 

printf("\nThis Editor provides the following options \n"); 
printf("R :opens a file and reads it into a buffer\n   If file doesnot exist creates a new file for editing\n"); 
printf("I : Insert into  the currently open file\n"); 
printf("D : Delete from  the currently open file\n"); 
printf("P: Print the file\n");
printf("X :closes the current file and allows you to open another file\n"); 
printf("Q :quit discarding any unsaved changes\n"); 
 
c=getchar();                            
switch(c)                             
{ 
case 'r' : 
case 'R' : inp(); 
	break; 
case 'i' :
case 'I' :
	addnode();
	break;

case 'd' : 
case 'D' : if(temp==head)                //checking if list is empty 
{ 
printf("\nFile empty\n"); 
break; 
} 
temp=temp->prev; 
delnode(temp->next);            //deleting the node 
printf("\nLine deleted\n"); 
print1();                //printing the list 
if(temp->index) 
printf("\nYou are currently at line number %d",temp->index); 
if(((temp->prev)==NULL)&&(temp->next)!=NULL) 
temp=temp->next; 
else if((temp==head)&&((temp->next)==NULL)) 
printf("\nFile empty");        //printing message if list is empty 
break; 
 
 

case 'p': 
case 'P' : print1();
	break;
case 'x' : 
case 'X' : closer(); 
	break; 
case 'q' : 
case 'Q' : system("clear"); 
	exit(1); 
break; 
} 
} 
}                                
 
 
void addnode(char t[],struct dll *q)        //function to add a new node after a node q 
{ 
struct dll*p=(struct dll*)malloc(sizeof(struct dll)); 
struct dll *temp=q->next; 
strcpy(p->s,t); 
p->prev=q; 
p->next=q->next; 
 
if((q->next)!=NULL)        //adding the node  
{ 
((q->next)->prev)=p; 
while(temp!=NULL) 
{ 
(temp->cursor)++;        //incrementing the cursor 
 
temp=temp->next; 
} 
} 
q->next=p; 
p->cursor = q->cursor + 1;                    //setting the cursor 
} 
 
 
 
void delnode(struct dll *p)                    //function to delete a node 
{ 
struct dll *temp=p->next; 
((p->prev->next))=p->next; 
if(p->next!=NULL) 
{ 
((p->next)->prev)=p->prev; 
while(temp!=NULL) 
{ 
(temp->cursor)--;        //decrementing the cursor 
 
temp=temp->next; 
} 
} 
free(p);                        
} 
 
 
 
void clearlist(void)                        
{ 
while(head->next!=NULL) 
delnode(head->next);                    //deleting all nodes except head 
} 
 
 
 
void print1(void)            
{ 
struct dll *temp=head; 
system("clear"); 
while(temp->next!=NULL) 
{ 
temp=temp->next; 
printf("%d %s\n",temp->index,temp->s);            
} 
} 
 
 
 
void closer(void)                //function to close the file. 
{ 
if(fp==NULL) 
return; 
fclose(fp); 
fp=NULL; 
clearlist();                        
} 
 
 
 
void inp(void) 
{ 
struct dll *buff=head;                        //temporaty variable 
char c; 
char buf[200];                            //array to store input line 
 
if(fp!=NULL)                            //checking for files opened earlier 
{ 
printf("\nThere is another file open it will be closed\ndo you want to continue ?(Y/N):"); 
c=getchar(); 
if(c=='n'||c=='N') 
return; 
else 
closer(); 
} 
 
fflush(stdin); 
printf("\nEnter the file name :"); 
scanf("%s",file); 
getchar(); 
fflush(stdin); 
clearlist(); 
 
fp=fopen(file,"r");                       
if(fp==NULL)                         
{ 
printf("\nThe file doesnot exist do you want to create one?(Y/N) :"); 
c=getchar(); 
getchar(); 
if(c=='N'||c=='n') 
return; 
else 
{ 
fp=fopen(file,"w");                //creating new file 
edit(); 
return; 
} 
} 
 
if(feof(fp)) 
return; 
 
while((fgets(buf,201,fp))!=NULL)                //taking input from file 
{ 
addnode(buf,buff); 
buff=buff->next; 
} 
edit();                            //calling the edit function 
} 
 
  
void addline(struct dll *temp)                    //adding a new line via input from user 
{ 
char buff[200]; 
printf("\nenter the new line :\n"); 
gets(buff);                            //taking the new line 
addnode(buff,temp);                        //ceatng the new node 
} 


//Did this in C and others in java as i couldn't understand how to do this program without pointers which are not available in java. Also, I tried my best in this program, but not sure whether it is perfect.
 
