#pragma strict
var next:KeyCode;
var restart:KeyCode;
var back:KeyCode;
var end:KeyCode;
var dia:KeyCode;
var dialog:int=0;
var x:int=0;
var d1:int=0;
var d2:int=0;
var d3:int=0;
var d4:int=0;
var d5:int=0;
var ecount:int=0;
function Start () {

}

function Update () {

	if(Input.GetKey(next))
	{
		Application.LoadLevel(3);
	}
	
	else if(Input.GetKey(restart))
	{
		Application.LoadLevel(2);
		}
		
	else if(Input.GetKey(back))
	{
		Application.LoadLevel(1);
	}
	else if(Input.GetKey(end) && ecount==0)
	{
		dialog=1;
		ecount=1;
		x++;
		d1++;
		d2++;
		d3++;
		d4++;
		if(d5<5)
		{
			d5++;
		}
	}
	else if(Input.GetKey(dia))
	{
		ecount=0;
		dialog=0;
		}
		 
			

}
function OnGUI ()
{
	GUI.Label( new Rect(700,40,300,300),"Press (D) then (Escape) to show the next sentence");
	if(x<2 && dialog ==1 )
	{
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
	}
	else if(d1==1)
	{
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
		
	}	
	else if(x<3 && dialog==1)
	{
		d1=2;
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
		GUI.Label( new Rect(630,110,200,200)," Hello ");
	}
	else if(d2==2)
	{
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
		GUI.Label( new Rect(630,110,200,200)," Hello ");
	}
	else if(x<4 && dialog==1)
	{
		d2=3;
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
		GUI.Label( new Rect(630,110,200,200)," Hello ");
		GUI.Label( new Rect(780,110,300,300)," My daughter has been kidnapped and i have some evidence and i know who did it! ");
	}
	
	else if(d3==3)
	{
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
		GUI.Label( new Rect(630,110,200,200)," Hello ");
		GUI.Label( new Rect(780,110,300,300)," My daughter has been kidnapped and i have some evidence and i know who did it! ");
		dialoguecount.count=1;
	}
	else if(x<5 && dialog==1)
	{
		d3=4;
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
		GUI.Label( new Rect(630,110,200,200)," Hello ");
		GUI.Label( new Rect(780,110,300,300)," My daughter has been kidnapped and i have some evidence and i know who did it! ");
		GUI.Label( new Rect(630,150,200,200)," Show me the evidence ");
	}
	else if(d4==4)
	{
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
		GUI.Label( new Rect(630,110,200,200)," Hello ");
		GUI.Label( new Rect(780,110,300,300)," My daughter has been kidnapped and i have some evidence and i know who did it! ");
		GUI.Label( new Rect(630,150,200,200)," Show me the evidence ");
	}
	else if(x<6 && dialog==1)
	{
		d4=5;
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
		GUI.Label( new Rect(630,110,200,200)," Hello ");
		GUI.Label( new Rect(780,110,300,300)," My daughter has been kidnapped and i have some evidence and i know who did it! ");
		GUI.Label( new Rect(630,150,200,200)," Show me the evidence ");
		GUI.Label( new Rect(630,170,300,300),"We Cant help you with this gang. But i will tell you where to go to get some people to help you");
		
	}
	else if(d5==5)
	{
		GUI.Label( new Rect(780,90,200,200)," Hello Officer ");
		GUI.Label( new Rect(630,110,200,200)," Hello ");
		GUI.Label( new Rect(780,110,300,300)," My daughter has been kidnapped and i have some evidence and i know who did it! ");
		GUI.Label( new Rect(630,150,200,200)," Show me the evidence ");
		GUI.Label( new Rect(630,170,300,300),"We Cant help you with this gang. But i will tell you where to go to get some people to help you");

	}
}