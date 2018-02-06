#include <iostream>

using namespace std;

int main()
{
    int n, nextSquare, nextDiag;
    cin>>n;
    for(int i=1; i<1000; i+=2){
        nextDiag = i*i;
        nextSquare = i;
        if(n<=nextDiag) break;
    }

    if(nextDiag == n){
        cout<<nextSquare - 1;
    }

    int downLeft = nextDiag - nextSquare + 1;

    int toCenter = (nextSquare/2);
    int middle;

    if(n >= downLeft){ //BottomSide
        middle = nextDiag - toCenter;
        if(n > middle){
            cout<< n-middle+toCenter;
            return 0;
        }
        else{
            cout<< middle - n + toCenter;
            return 0;
        }
    }

    int upLeft = downLeft - nextSquare + 1;

    if(n >= upLeft){ // LeftSide
        int middle = downLeft - toCenter;
        if(n>middle){
            cout<< n-middle + toCenter;
            return 0;
        }
        else{
            cout<< middle-n + toCenter;
            return 0;
        }
    }

    int upRight = upLeft - nextSquare + 1;

    if ( n>= upRight){ //TopSide
        int middle = upLeft - toCenter;
        if(n>middle){
            cout<< n-middle+toCenter;
            return 0;
        }
        else{
            cout<< middle - n + toCenter;
            return 0;
        }

    }

    middle = upRight - toCenter;

    if(n>middle){
            cout<< n-middle+toCenter;
            return 0;
        }
        else{
            cout<< middle - n + toCenter;
            return 0;
        }



    return 0;
}
