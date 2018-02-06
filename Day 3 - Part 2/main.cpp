#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    int arr[101][101];
    for(int i=0; i<101; i++){
        for(int j=0; j<101; j++){
            arr[i][j]=0;
        }
    }
    arr[56][56]=1;
    arr[56][57]=1;
    arr[55][57]=2;
    arr[55][56]=4;
    arr[55][55]=5;
    arr[56][55]=10;
    arr[57][55]=11;
    arr[57][56]=23;
    arr[57][57]=25;
    int i=57;
    int j=57;
    int cnt = 4;
    int n;
    cin>>n;
    while(true){
        //goUP
        j++;
        arr[i][j]= arr[i][j-1] + arr[i-1][j-1]; // desen dolen kos
        cout<<arr[i][j]<<" "<<i<<" "<<j<<endl;
        if(arr[i][j]>n){
            cout<<std::abs(i-57) + std::abs(j-57);
            return 0;
        }

        for(int x=0; x<cnt-2; x++)
        {
            i--;
            arr[i][j] = arr[i+1][j] + arr[i+1][j-1] + arr[i][j-1] + arr[i-1][j-1];
            cout<<arr[i][j]<<" "<<i<<" "<<j<<endl;
            if(arr[i][j]>n){
            cout<<std::abs(i-57) + std::abs(j-57);
            return 0;
        }
        }

        i--;
        arr[i][j] = arr[i+1][j] + arr[i+1][j-1]; // desen goren kos
        cout<<arr[i][j]<<" "<<i<<" "<<j<<endl;
        if(arr[i][j]>n){
            cout<<std::abs(i-57) + std::abs(j-57);
            return 0;
        }

        for(int x=0; x<cnt-1; x++){
            j--;
            arr[i][j] = arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j] + arr[i+1][j-1];
            cout<<arr[i][j]<<" "<<i<<" "<<j<<endl;
            if(arr[i][j]>n){
            cout<<std::abs(i-57) + std::abs(j-57);
            return 0;
        }
        }

        j--;
        arr[i][j] = arr[i][j+1] + arr[i+1][j+1]; // lev goren kos
        cout<<arr[i][j]<<" "<<i<<" "<<j<<endl;
        if(arr[i][j]>n){
            cout<<std::abs(i-57) + std::abs(j-57);
            return 0;
        }

        for(int x=0; x<cnt-1; x++){
            i++;
            arr[i][j] = arr[i-1][j] + arr[i-1][j+1] + arr[i][j+1] + arr[i+1][j+1];
            cout<<arr[i][j]<<" "<<i<<" "<<j<<endl;
            if(arr[i][j]>n){
            cout<<std::abs(i-57) + std::abs(j-57);
            return 0;
        }
        }

        i++;
        arr[i][j] = arr[i-1][j] + arr[i-1][j+1]; // lev dolen kos
        cout<<arr[i][j]<<" "<<i<<" "<<j<<endl;
        if(arr[i][j]>n){
            cout<<std::abs(i-57) + std::abs(j-57);
            return 0;
        }

        for(int x=0; x<cnt; x++){
            j++;
            arr[i][j] = arr[i][j-1] + arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1];
            cout<<arr[i][j]<<" "<<i<<" "<<j<<endl;
            if(arr[i][j]>n){
            cout<<std::abs(i-57) + std::abs(j-57);
            return 0;
        }
        }
        cnt+=2;


    }

    return 0;
}
