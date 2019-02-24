#pragma strict
var next:KeyCode;
var back:KeyCode;
var restart:KeyCode;
static var ch1:int=0;
static var ch2:int=0;
static var ch3:int=0;
static var ch4:int=0;
var themoney: GUISkin ;

function Update()
{
	if(Input.GetKey(next) &&C1.count==2)
	{
		Application.LoadLevel(5);
	}
	
	else if(Input.GetKey(restart))
	{
		Application.LoadLevel(4);
	}
	else if(Input.GetKey(back))
	{
		Application.LoadLevel(3);
	}
	
}
		
function OnGUI ()
{
	GUI.skin= themoney;
	GUI.Label( new Rect(1080,180,200,200),"Money ");
	GUI.Label( new Rect(1080,210,200,200)," "+C1.money);
	}