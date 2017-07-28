# AutoEdittext
Create Edittext widgets with hints and get values from it

how to use 

//inside your activity
//default inputtype is text
//for number type use <your hint here>:number
//for password type use  <your hint here>:password
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
                    String age = nm.get(1);
                    String place = nm.get(2);
                    String mob = nm.get(3);
                    String email = nm.get(4);
                    String username = nm.get(5);
                    String pass = nm.get(6);
                    b.setText(name+"\n"+age+"\n"+place+"\n"+mob+"\n"+email+"\n"+username+"\n"+pass+"\n");
                }
                else {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
 
