#pragma strict
static var player: int;
static var computer:int;
var s1: KeyCode;
var s2: KeyCode;
var s3: KeyCode;
var s4: KeyCode;
var s: KeyCode;
var att: KeyCode;
var turn: KeyCode;
var comp: KeyCode;
static var playercount: int;
var attack: int[];
var attack2: int[];
var healthh: int=2;
var yourship:int=0;
static var enemyship:int=0;
var shipreal:int=0;
var info :GUISkin;
var randnu: int;
var numbers: int[];
var numbers2: int[];
var count:int=0;
var count2:int=0;
var shipscount1:int=0;
var shipscount2:int=0;
var check:int=0;
var i:int=0;
var z:int=0;
var x:int =0;
var g:int =0;
var c:int =0;
var status: String;
var rechoose:String;
var startgame:int=0;
var ships : int[];
var ships2 : int[];
var destroy :int[];
var destroycounter:int=0;
static var destroyedships:int [];
var destroy2 :int[];
var destroycounter2:int=0;
static var destroyedships2:int [];
var playerOrComp:String;
function Start () {
	player=2;
	playerOrComp="Player 2";
	playercount=4;
	ships = new int[4];
	ships2 = new int[4];
	attack = new int[2];
	attack2 = new int[2];
	numbers=new int[4];
	numbers2=new int[4];
	destroy=new int[4];
	destroy2=new int[4];
	destroyedships=new int[4];
	destroyedships2=new int [4];
	if(computer==1)
	{
		playerOrComp="Computer";
	}
}


function Update () {
	
	//Computer
	if(computer==1 && player==2 && playercount==0)
	{
		if(ship11.health==1)
		{
			attack2[0]=1;
		}
		else if(ship12.health==1)
		{
			attack2[0]=2;
		}
		else if(ship13.health==1)
		{
			attack2[0]=3;
		}
		else if(ship14.health==1)
		{
			attack2[0]=4;
		}
		else 
		{
			for( c=0;c<20;c++)
			{
				randnu=Random.Range(1,5); 
				if(destroyedships[randnu-1]==0 )
				{
					attack2[0]=randnu;
					c=21;
				}
			}
		}
		yourship=attack2[0];
		rechoose=" ";
		playercount=2;
	}
	else if(computer==1 && player==2 && playercount==2 )
	{
		for( c=0;c<20;c++)
		{
			randnu=Random.Range(1,5); 
			if(destroyedships[randnu-1]==0 )
			{
				attack2[1]=randnu;
				enemyship=attack2[1];
				playercount=3;
				c=21;
			}
		}
	}
	//Player
	else if(Input.GetKey(s1)&& playercount==0 )
	{
		if(player==1)
		{
			if(destroyedships2[0]==1 )
			{
				rechoose="Enemey Ship number (1) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack[0]=1;
				yourship=attack[0];
				rechoose=" ";
			}
		}
		else if(player==2 && computer==0)
		{
			if(destroyedships[0]==1  )
			{
				rechoose="Enemey Ship number (1) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack2[0]=1;
				yourship=attack2[0];
				rechoose=" ";
			}
		}
	}
	else if(Input.GetKey(s2)&& playercount==0 )
	{
		if(player==1)
		{
			if(destroyedships2[1]==1 )
			{
				rechoose="Enemey Ship number (2) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack[0]=2;
				yourship=attack[0];
				rechoose=" ";
			}
		}
		else if(player==2 && computer==0)
		{
			if(destroyedships[1]==1  )
			{
				rechoose="Enemey Ship number (2) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack2[0]=2;
				yourship=attack2[0];
				rechoose=" ";
			}
		}
		
	}
	
	
	else if(Input.GetKey(s3)&& playercount==0 )
	{
		if(player==1)
		{
			if( destroyedships2[2]==1 )
			{
				rechoose="Enemey Ship number (3) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack[0]=3;
				yourship=attack[0];
				rechoose=" ";
			}
		}
		else if(player==2 && computer==0)
		{
			if(destroyedships[2]==1  )
			{
				rechoose="Enemey Ship number (3) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack2[0]=3;
				yourship=attack2[0];
				rechoose=" ";
			}
		}
		
	}
	else if(Input.GetKey(s4)&& playercount==0 )
	{
		if(player==1)
		{
			if(destroyedships2[3]==1 )
			{
				rechoose="Enemey Ship number (4) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack[0]=4;
				yourship=attack[0];
				rechoose=" ";
			}
		}
		else if(player==2 && computer==0)
		{
			if(destroyedships[3]==1  )
			{
				rechoose="Enemey Ship number (4) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack2[0]=4;
				yourship=attack2[0];
				rechoose=" ";
			}
		}
		
	}
	else if(Input.GetKey(att) && playercount==0 )
	{
		if(attack[0]!=0 || attack2[0]!=0)
		{
			playercount=2;
			rechoose=" ";
		}
	}
	else if(Input.GetKey(s1)&& playercount==2 )
	{
		
		if(player==1)
		{
			if(destroyedships2[0]==1)
			{
				rechoose="Ship number (1) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack[1]=1;
				enemyship=attack[1];
				rechoose=" ";
			}
		}
		else if(player==2)
		{
			if(destroyedships[0]==1)
			{
				rechoose="Ship number (1) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack2[1]=1;
				enemyship=attack2[1];
				rechoose=" ";
			}
		}
			
	}
	else if(Input.GetKey(s2)&& playercount==2 )
	{
		if(player==1)
		{
			if(destroyedships2[1]==1)
			{
				rechoose="Ship number (2) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack[1]=2;
				enemyship=attack[1];
				rechoose=" ";
			}
		}
		else if(player==2)
		{
			if(destroyedships[1]==1)
			{
				rechoose="Ship number (2) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack2[1]=2;
				enemyship=attack2[1];
				rechoose=" ";
			}
		}
	}
	else if(Input.GetKey(s3)&& playercount==2 )
	{
		if(player==1)
		{
			if(destroyedships2[2]==1)
			{
				rechoose="Ship number (3) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack[1]=3;
				enemyship=attack[1];
				rechoose=" ";
			}
		}
		else if(player==2)
		{
			if(destroyedships[2]==1)
			{
				rechoose="Ship number (3) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack2[1]=3;
				enemyship=attack2[1];
				rechoose=" ";
			}
		}
	}
	else if(Input.GetKey(s4)&& playercount==2 )
	{
		if(player==1)
		{
			if(destroyedships2[3]==1)
			{
				rechoose="Ship number (4) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack[1]=4;
				enemyship=attack[1];
				rechoose=" ";
			}
		}
		else if(player==2)
		{
			if(destroyedships[3]==1)
			{
				rechoose="Ship number (4) is already destroyed .. Choose Another ship!";
			}
			else
			{
				attack2[1]=4;
				enemyship=attack2[1];
				rechoose=" ";
			}
		}	
	}
	else if(Input.GetKey(s) &&playercount==2 || playercount==3)
	{
		if(attack[1]!=0 || attack2[1]!=0)
		{	
		
			playercount=4;
			rechoose=" ";
			status="Missed!";
			if(player==1)
			{			
				playercount=4;
				shipreal=ships2[attack[1]-1];
				if(attack[0]==shipreal)
				{
					status="Hit!";
					if(attack[0]==1)
					{
						ship21.health=ship21.health-1;
						if(ship21.health==0)
						{
							destroy2[destroycounter2]=1;
							destroycounter2++;
							ships2[0]=0;
							destroyedships2[0]=1;
						}
					}
					else if(attack[0]==2)
					{
						ship22.health=ship22.health-1;
						if(ship22.health==0)
						{
							destroy2[destroycounter2]=2;
							destroycounter2++;
							ships2[1]=0;
							destroyedships2[1]=1;
						}
					}
					else if(attack[0]==3)
					{
						ship23.health=ship23.health-1;
						if(ship23.health==0)
						{
							destroy2[destroycounter2]=3;
							destroycounter2++;
							ships2[2]=0;
							destroyedships2[2]=1;
						}
					}
					else if(attack[0]==4)
					{
						ship24.health=ship24.health-1;
						if(ship24.health==0)
						{
							destroy2[destroycounter2]=4;
							destroycounter2++;
							ships2[3]=0;
							destroyedships2[3]=1;
						}
					}
				}			
				if(shipreal==1)
				{
					healthh=ship21.health;
				}
				else if(shipreal==2)
				{
					healthh=ship22.health;
				}
				else if(shipreal==3)
				{
					healthh=ship23.health;
				}
				else if(shipreal==4)
				{
					healthh=ship24.health;
				}
			}
			else if(player==2)
			{
				shipreal=ships[attack2[1]-1];
				if(attack2[0]==shipreal)
				{
					status="Hit!";
					if(attack2[0]==1)
					{
						ship11.health=ship11.health-1;
						if(ship11.health==0)
						{
							destroy[destroycounter]=1;
							destroycounter++;
							ships[0]=0;
							destroyedships[0]=1;
						}
					}
					else if(attack2[0]==2)
					{
						ship12.health=ship12.health-1;
						if(ship12.health==0)
						{
							destroy[destroycounter]=2;
							destroycounter++;
							ships[1]=0;
							destroyedships[1]=1;
						}
					}
					else if(attack2[0]==3)
					{
						ship13.health=ship13.health-1;
						if(ship13.health==0)
						{
							destroy[destroycounter]=3;
							destroycounter++;
							ships[2]=0;
							destroyedships[2]=1;
						}
					}
					else if(attack2[0]==4)
					{
						ship14.health=ship14.health-1;
						if(ship14.health==0)
						{
							destroy[destroycounter]=4;
							destroycounter++;
							ships[3]=0;
							destroyedships[3]=1;
						}
					}
				}			
				if(shipreal==1)
				{
					healthh=ship11.health;
				}
				else if(shipreal==2)
				{
					healthh=ship12.health;
				}
				else if(shipreal==3)
				{
					healthh=ship13.health;
				}
				else if(shipreal==4)
				{
					healthh=ship14.health;
				}
			}
		}
	}
	else if(Input.GetKey(turn)&& playercount==4 )
	{
		if(computer==1 && player==2 && startgame>0)
		{
			playercount=5;
		}
		else
		{
			playercount=0;
		}
		startgame++;
		if(player==1)
		{
			player=2;
			count=0;
			shipscount1=0;
			for( i=0; i<100; i++)
			{
				if(shipscount1==4)
				{
					i=101;
				}
				randnu=Random.Range(1,5);
				for( z=0; z<count; z++)
				{
					if(randnu==numbers[z])
					{
						check=-1;
					}
				}
				for( x=0; x<destroycounter; x++)
				{
					if(randnu==destroy[x])
					{
						check=-1;
					}
				}
				if(check!=-1)
				{
					for( g=shipscount1; g<4; g++)
					{
						if(destroyedships[g]==0)
						{
							ships[shipscount1]=randnu;
							shipscount1++;
							numbers[count]=randnu;
							count++;
							break;
						}
						else
						{
							shipscount1++;
						}
					}
					
				}
				check=0;
			}
			attack[0]=0;
			attack[1]=0;
		}
		else if(player==2)
		{
			player=1;
			count2=0;
			shipscount2=0;
			for( i=0; i<100; i++)
			{
				if(shipscount2==4)
				{
					i=101;
				}
				randnu=Random.Range(1,5);
				for( z=0; z<count2; z++)
				{
					if(randnu==numbers2[z])
					{
						check=-1;
					}
				}
				for( x=0; x<destroycounter2; x++)
				{
					if(randnu==destroy2[x])
					{
						check=-1;
					}
				}
				if(check!=-1)
				{
					for( g=shipscount2; g<4; g++)
					{
						if(destroyedships2[g]==0)
						{
							ships2[shipscount2]=randnu;
							shipscount2++;
							numbers2[count2]=randnu;
							count2++;
							break;
						}
						else
						{
							shipscount2++;
						}
					}
					
				}
				check=0;
			}
			attack2[0]=0;
			attack2[1]=0;
			if(destroycounter2==3)
			{
				playercount=6;
			}
			if(destroycounter==3)
			{
				playercount=7;
			}
			
		}	
		
	}
	else if(Input.GetKey(comp) && playercount==5)
	{
		playercount=0;
	}
	

}
function OnGUI ()
{	
	GUI.skin=info;
	if(playercount==4 && startgame==0)
	{
		GUI.Label( new Rect(300,10,600,600),"Press T to Start the game!");
		GUI.Label( new Rect(70,50,400,400),""+playerOrComp);
		GUI.Label( new Rect(70,100,400,400),"Ships Left:");
		GUI.Label( new Rect(80,120,400,400),4-destroycounter2+" ");
		GUI.Label( new Rect(700,50,400,400),"Player 1");
		GUI.Label( new Rect(700,100,400,400),"Ships Left:");
		GUI.Label( new Rect(710,120,400,400),4-destroycounter+" ");
	}
	else if(playercount==0)
	{
		GUI.Label( new Rect(300,10,600,600),"Player "+player+" turn!");
		GUI.Label( new Rect(70,50,400,400),""+playerOrComp);
		GUI.Label( new Rect(70,100,400,400),"Ships Left:");
		GUI.Label( new Rect(80,120,400,400),4-destroycounter2+" ");
		GUI.Label( new Rect(700,50,400,400),"Player 1");
		GUI.Label( new Rect(700,100,400,400),"Ships Left:");
		GUI.Label( new Rect(710,120,400,400),4-destroycounter+" ");
		GUI.Label( new Rect(300,30,600,600),"Choose Your Ship!.. & Click A to Attack");
		GUI.Label( new Rect(300,50,400,600),""+rechoose);
	}
	else if(playercount==2)
	{
		GUI.Label( new Rect(300,10,600,600),"Player "+player+" turn!");
		GUI.Label( new Rect(70,50,400,400),""+playerOrComp);
		GUI.Label( new Rect(70,100,400,400),"Ships Left:");
		GUI.Label( new Rect(80,120,400,400),4-destroycounter2+" ");
		GUI.Label( new Rect(700,50,400,400),"Player 1");
		GUI.Label( new Rect(700,100,400,400),"Ships Left:");
		GUI.Label( new Rect(710,120,400,400),4-destroycounter+" ");
		GUI.Label( new Rect(300,30,600,600),"Your Ship number is "+yourship);
		GUI.Label( new Rect(300,50,600,600),"Attack now!.. Choose enemy's ship (Click S to attack)");
		GUI.Label( new Rect(300,70,400,600),""+rechoose);
	}
	else if(playercount==4 && startgame>0 &&computer==1 && player==2)
	{
		rechoose=" ";
		GUI.Label( new Rect(300,10,600,600),"Click Another T to Show the Computer Attack!");
		GUI.Label( new Rect(70,50,400,400),""+playerOrComp);
		GUI.Label( new Rect(70,100,400,400),"Ships Left:");
		GUI.Label( new Rect(80,120,400,400),4-destroycounter2+" ");
		GUI.Label( new Rect(700,50,400,400),"Player 1");
		GUI.Label( new Rect(700,100,400,400),"Ships Left:");
		GUI.Label( new Rect(710,120,400,400),4-destroycounter+" ");
	}
	else if(playercount==4 && startgame>0 )
	{
		rechoose=" ";
		GUI.Label( new Rect(300,10,600,600),"Player "+player+" turn!");
		GUI.Label( new Rect(70,50,400,400),""+playerOrComp);
		GUI.Label( new Rect(70,100,400,400),"Ships Left:");
		GUI.Label( new Rect(80,120,400,400),4-destroycounter2+" ");
		GUI.Label( new Rect(700,50,400,400),"Player 1");
		GUI.Label( new Rect(700,100,400,400),"Ships Left:");
		GUI.Label( new Rect(710,120,400,400),4-destroycounter+" ");
		GUI.Label( new Rect(300,30,600,600),"Your Ship number is "+yourship);
		GUI.Label( new Rect(300,50,600,600),"Ship's enemy number that you choosed is "+enemyship);
		GUI.Label( new Rect(300,70,600,600),"Ship's enemy real number is  "+shipreal+"   "+status);
		GUI.Label( new Rect(300,90,600,600),"Ship's enemy number "+shipreal+" health is  "+healthh);
		GUI.Label( new Rect(300,110,600,600),"Click T to Change players!");
	}
	
	else if(playercount==5 && startgame>0)
	{
		rechoose=" ";
		GUI.Label( new Rect(300,10,600,600),"Computer turn!");
		GUI.Label( new Rect(70,50,400,400),""+playerOrComp);
		GUI.Label( new Rect(70,100,400,400),"Ships Left:");
		GUI.Label( new Rect(80,120,400,400),4-destroycounter2+" ");
		GUI.Label( new Rect(700,50,400,400),"Player 1");
		GUI.Label( new Rect(700,100,400,400),"Ships Left:");
		GUI.Label( new Rect(710,120,400,400),4-destroycounter+" ");
		GUI.Label( new Rect(300,30,600,600),"Computer's ship number is "+yourship);
		GUI.Label( new Rect(300,50,600,600),"your ship number that computer choosed is "+enemyship);
		GUI.Label( new Rect(300,70,600,600),"your ship real number is  "+shipreal+"   "+status);
		GUI.Label( new Rect(300,90,600,600),"your ship number "+shipreal+" health is  "+healthh);
		GUI.Label( new Rect(300,110,600,600),"Click C to Attack!");
	}
	else if(playercount==6 && startgame>0)
	{
		GUI.Label( new Rect(350,100,600,600),"Player 1 Won!!");
	}
	else if(playercount==7 && startgame>0)
	{
		GUI.Label( new Rect(350,100,600,600),playerOrComp+" Won!!");
	}
		
	
}