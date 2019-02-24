#pragma strict
var dice:KeyCode;
var d1: KeyCode;
var d1count:int=0;
var d2: KeyCode;
var d2count:int=0;
var d3:KeyCode;
var d3count:int=0;
var d4:KeyCode;
var d4count:int=0;
var qa: KeyCode;
var qb:KeyCode;
var qcount: int=0;
var qacount: int=0;
var qbcount: int=0;
var z:int;
var number:int;
var dicecount:int=10;
var dicecountc:int=0;
var next:KeyCode;
var restart:KeyCode;
var back:KeyCode;
var thescore: GUISkin ;
var dicenumber: int=0;
var playdice: int=0;

function Start () {
	C1.money=20;
	C1.count=0;
	transform.audio.Stop();
	
}

function Update () {
	if(Input.GetKey(next))
	{
		Application.LoadLevel(4);
		}
	else if(Input.GetKey(restart))
	{
		Application.LoadLevel(3);
		C1.money=20;
	}
	
	else if(Input.GetKey(back))
	{
		Application.LoadLevel(2);
	}
	else if(Input.GetKey(d1))
	{
		z=1;
		if (z==number && d1count==0 && dicecount>0 && playdice==1)
		{
			C1.money=C1.money+20;
			d1count++;
			dicecount--;
			dicenumber=number;
			playdice=0;
			transform.audio.Play();
		}
		
		else if (z!=number && d1count==0 && dicecountc==0 && playdice==1)
		{
			dicecount--;
			dicecountc++;
			dicenumber=number;
			playdice=0;
			
		}
	}
	else if(Input.GetKey(d2))
	{
		z=2;
		if (z==number && d2count==0 && dicecount>0 && playdice==1)
		{
			C1.money=C1.money+20;
			d2count++;
			dicecount--;
			dicenumber=number;
			playdice=0;
			transform.audio.Play();
		}
		
		else if (z!=number && d2count==0 && dicecountc==0 && playdice==1)
		{
			dicecount--;
			dicecountc++;
			dicenumber=number;
			playdice=0;
		}	
	}
	else if(Input.GetKey(d3))
	{
		z=3;
		if (z==number && d3count==0 && dicecount>0 && playdice==1)
		{
			C1.money=C1.money+20;
			d3count++;
			dicecount--;
			dicenumber=number;
			playdice=0;
			transform.audio.Play();
		}
		else if (z!=number && d3count==0 && dicecountc==0 && playdice==1)
		{
			dicecount--;
			dicecountc++;
			playdice=0;
		}
			
	}
	else if(Input.GetKey(d4))
	{
		z=4;
		if (z==number && d4count==0 && dicecount>0 && playdice==1)
		{
			C1.money=C1.money+20;
			d4count++;
			dicecount--;
			dicenumber=number;
			playdice=0;
			transform.audio.Play();
		}
		
		else if (z!=number && d4count==0 && dicecountc==0 && playdice==1)
		{
			dicecount--;
			dicecountc++;
			dicenumber=number;
			playdice=0;
		}	
	}
	else if(Input.GetKey(dice))
	{
		number = Random.Range(1,5);
		playdice=1;	
	}
	else if(Input.GetKey(qa))
	{
		if(qacount==0&&qcount==0)
		{
			C1.money=C1.money+50;
			qacount++;
			qcount++;
			transform.audio.Play();
				
		}
	}
	else if(Input.GetKey(qb))
	{
		if(qbcount==0 &&qcount==0)
		{
			Debug.Log("Wrong answer!");
			qbcount++;
			qcount++;
		}
	}
	else
	{
		d1count=0;
		d2count=0;
		d3count=0;
		d4count=0;
		C1.money=C1.money+0;
		dicecount=dicecount-0;
		dicecountc=0;
	}
}
function OnGUI ()
{
	GUI.skin=thescore;
	GUI.Label( new Rect(300,50,600,600),"Roll The dice(D) then choose a number");
	GUI.Label( new Rect(570,90,200,200)," Money "+C1.money);
	if(dicecount>0)
	{
	GUI.Label( new Rect(570,110,300,300),"Tries left "+dicecount);
	}
	else
	{
		GUI.Label( new Rect(570,110,300,300),"Tries left "+0);
	}
	
	GUI.Label( new Rect(570,130,200,200),"Your Number "+z);
	
	GUI.Label( new Rect(570,150,200,200)," Dice "+dicenumber);
	
}