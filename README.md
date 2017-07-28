# AutoEdittext
Create Edittext widgets with hints and get values from it
add library by

edit in project level gradle



allprojects {
		repositories {
		
			...
			maven { url 'https://jitpack.io' }
			
			
		}
	}
	
	
	
edit in app level gradle




dependencies {


	        compile 'com.github.ysk15:AutoEdittext:-cc510a0d7c-1'
	}
	
	
![Alt text](https://user-images.githubusercontent.com/30522134/28714091-77a26312-73af-11e7-8dc3-beff5fc0d0aa.png "Screen Shot")




how to use 


default inputtype is text ,for number type use <your hint here>:number ,for password type use  <your hint here>:password.


	
	Inside your Activity
	
        final String [] names = {"name","age:number","place","mob:number","email","username","pass:password"};
        final RelativeLayout rl = (RelativeLayout)findViewById(R.id.activity_main);
        new CreateInputs(MainActivity.this,names,rl).create();
         final Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> nm = new ArrayList<String>(new CreateInputs(MainActivity.this,names,rl).getvalues(rl)) ;
                //get all inputs as an arraylist of string
                //check if any fields are empty
                if(nm.size()==names.length){
                //get values on the repective order
                    String name = nm.get(0);
                }
                else {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
 
