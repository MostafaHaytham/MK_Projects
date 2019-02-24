Imports System.Threading
Imports Excel = Microsoft.Office.Interop.Excel
Imports System.IO

Public Class Form1
    Dim a As New Process
    Dim b As New Process
    Dim fileReader As System.IO.StreamReader
    Dim APP As New Excel.Application
    Dim worksheet As Excel.Worksheet
    Dim workbook As Excel.Workbook
    Dim f1 As String = ""
    Dim f2 As String = ""
    Dim f3 As String = ""
    Dim f4 As String = ""
    Dim lastCustomerNumber As String = " "
    Dim sleep1 As Integer = 100 '100
    Dim sleep2 As Integer = 250 '250
    Dim sleep3 As Integer = 500 '500
    Dim sleep4 As Decimal = 3000 '3000
    Dim count As Integer = 0


    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Try
            Dim startTime As String = TimeOfDay.ToString("h:mm:ss tt")
            Dim urlText As String = TextBox1.Text
            Dim clientProgram As String = TextBox2.Text
            If urlText.EndsWith(".txt") And clientProgram.EndsWith("Client.exe") Then
                createFiles()
                checkSpeed()
                FileOpen(2, "Files.txt", OpenMode.Input)
                Dim filesUrl As New ArrayList()
                Dim line As String
                Do While Not EOF(2)
                    line = LineInput(2)
                    filesUrl.Add(line)
                Loop
                FileClose(2)
                If filesUrl.Count = 5 Then
                    a.StartInfo.FileName = clientProgram
                    a.Start()
                    MsgBox("Click (Ok) then (Home) in the Client program when you finish logging in !!!")
                    f1 = filesUrl(1)
                    f2 = filesUrl(2)
                    f3 = filesUrl(3)
                    f4 = filesUrl(4)
                    Thread.Sleep(10000)
                    Using w As StreamWriter = File.AppendText("lostNumbers.txt")
                        w.WriteLine("")
                    End Using
                    Dim cardNumbers As New ArrayList()
                    Do
                        cardNumbers.Clear()
                        FileOpen(1, urlText, OpenMode.Input)
                        Do While Not EOF(1)
                            line = LineInput(1)
                            cardNumbers.Add(line)
                        Loop
                        FileClose(1)
                        Thread.Sleep(sleep1)
                        Search("smart card", 3)
                        Thread.Sleep(sleep3)
                        For i As Integer = 0 To cardNumbers.Count - 1
                            If Not a.HasExited Then
                                Thread.Sleep(sleep1)
                                SendKeys.SendWait(cardNumbers(i))
                                Thread.Sleep(sleep1)
                                SendKeys.SendWait("{TAB}")
                                Thread.Sleep(sleep1)
                                SendKeys.SendWait("{ENTER}")
                                Thread.Sleep(sleep4)
                                CopyAndPasteDataOnPage()
                                CheckCard(cardNumbers(i))
                                Search("smart card", 3)
                            Else
                                MsgBox("The Client Program is closed!" & vbCrLf & "Last Customer Number:" & lastCustomerNumber)
                                Environment.Exit(0)
                            End If
                        Next
                        System.IO.File.WriteAllText(urlText, "")
                        FileOpen(1, "lostNumbers.txt", OpenMode.Input)
                        cardNumbers.Clear()
                        Do While Not EOF(1)
                            line = LineInput(1)
                            cardNumbers.Add(line)
                        Loop
                        FileClose(1)
                        Using w As StreamWriter = File.AppendText(urlText)
                            For i As Integer = 0 To cardNumbers.Count - 1
                                w.WriteLine(cardNumbers(i))
                            Next
                        End Using
                        System.IO.File.WriteAllText("lostNumbers.txt", "")
                    Loop Until cardNumbers.Count = 0
                    Thread.Sleep(sleep2)
                    a.Kill()
                    Dim endTime As String = TimeOfDay.ToString("h:mm:ss tt")
                    MsgBox("FINISHED!" & vbCrLf & "Last Customer Number:" & lastCustomerNumber & vbCrLf & "Customer counter: " & count & vbCrLf & "Start time is: " & startTime & vbCrLf & "End time is: " & endTime)
                    Close()
                Else
                    MsgBox("There are no Output Files!")
                End If
            Else
                MsgBox("The .txt file or the client program is wrong!" & vbCrLf & "Last Customer Number:" & lastCustomerNumber)
            End If
        Catch ex As Exception
            Try
                FileOpen(1, "Test.txt", OpenMode.Input)
                FileClose(1)
            Catch ex1 As Exception
                FileClose(1)
            End Try
            MsgBox("Something wrong happened!" & vbCrLf & "Last Customer Number:" & lastCustomerNumber)
            Close()
        End Try

    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Using ofd As New OpenFileDialog()
            If ofd.ShowDialog() = DialogResult.OK Then
                TextBox1.Text = ofd.FileName
            End If
        End Using
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click
        Environment.Exit(0)
    End Sub

    Public Function CheckCard(ByVal currentCustomerNumber As String)
        Dim checked As Boolean = False
        FileOpen(1, "Test.txt", OpenMode.Input)
        Dim line As String
        Do While Not EOF(1)
            line = LineInput(1)
            If (line.StartsWith("Invalid Smart Card")) Then
                checked = True
                Exit Do
            ElseIf (line.StartsWith("SmartCard No " & currentCustomerNumber)) Then
                checked = True
                FileClose(1)
                WriteInExcel(2, currentCustomerNumber)
                FileOpen(1, "Test.txt", OpenMode.Input)
                Exit Do
            ElseIf (line.StartsWith("Smarctcard In Stock")) Then
                checked = True
                FileClose(1)
                WriteInExcel(1, currentCustomerNumber)
                FileOpen(1, "Test.txt", OpenMode.Input)
                Exit Do
            ElseIf (line.StartsWith("This is not normal beIN subscriber...")) Then
                checked = True
                FileClose(1)
                Dim dataAvaliablity = CreditCards(currentCustomerNumber)
                If (dataAvaliablity = 1) Then
                    WriteInExcel(3, currentCustomerNumber)
                End If
                FileOpen(1, "Test.txt", OpenMode.Input)
                Exit Do
            ElseIf (line.StartsWith("User Name")) Then
                Using w As StreamWriter = File.AppendText("lostNumbers.txt")
                    w.WriteLine(currentCustomerNumber)
                End Using
                checked = True
                a.Kill()
                Thread.Sleep(sleep4)
                Login()
            End If
        Loop
        FileClose(1)
        If checked = False Then
            Using w As StreamWriter = File.AppendText("lostNumbers.txt")
                w.WriteLine(currentCustomerNumber)
            End Using
        End If
        lastCustomerNumber = currentCustomerNumber

    End Function

    Public Function CreditCards(ByVal cardNumber As String) As Integer
        Search("new quarter", 0)
        Search("smart card", 3)
        SendKeys.SendWait(cardNumber)
        Thread.Sleep(sleep1)
        SendKeys.SendWait("{TAB}")
        Thread.Sleep(sleep1)
        SendKeys.SendWait("{ENTER}")
        Thread.Sleep(sleep4)
        CopyAndPasteDataOnPage()
        FileOpen(1, "Test.txt", OpenMode.Input)
        Dim line As String
        Do While Not EOF(1)
            line = LineInput(1)
            If (line.StartsWith(" Please Insert Smart Card Number")) Then
                line = LineInput(1)
                If (String.IsNullOrEmpty(line) Or line.StartsWith(" ")) Then
                    Search("copyright", 2)
                    FileClose()
                    CopyAndPasteDataOnPage()
                    FileOpen(1, "Test.txt", OpenMode.Input)
                    Do While Not EOF(1)
                        line = LineInput(1)
                        If (line.StartsWith("SmartCard No " & cardNumber)) Then
                            FileClose()
                            Search("home", 0)
                            Return 1
                        End If
                    Loop
                Else
                    Exit Do
                End If
            End If
        Loop
        Search("home", 0)
        FileClose()
        Search("bi-annual", 0)
        Search("smart card", 3)
        SendKeys.SendWait(cardNumber)
        Thread.Sleep(sleep1)
        SendKeys.SendWait("{TAB}")
        Thread.Sleep(sleep1)
        SendKeys.SendWait("{ENTER}")
        Thread.Sleep(sleep4)
        CopyAndPasteDataOnPage()
        FileOpen(1, "Test.txt", OpenMode.Input)
        Dim line2 As String
        Do While Not EOF(1)
            line2 = LineInput(1)
            If (line2.StartsWith(" Please Insert Smart Card Number")) Then
                line2 = LineInput(1)
                If (String.IsNullOrEmpty(line2) Or line2.StartsWith(" ")) Then
                    Search("copyright", 2)
                    FileClose()
                    CopyAndPasteDataOnPage()
                    FileOpen(1, "Test.txt", OpenMode.Input)
                    Do While Not EOF(1)
                        line2 = LineInput(1)
                        If (line2.StartsWith("SmartCard No " & cardNumber)) Then
                            FileClose()
                            Search("home", 0)
                            Return 1
                        End If
                    Loop
                    Search("home", 0)
                    FileClose()
                    Using w As StreamWriter = File.AppendText("lostNumbers.txt")
                        w.WriteLine(cardNumber)
                    End Using
                    Return 0
                Else
                    Exit Do
                End If
            End If
        Loop
        Search("home", 0)
        FileClose()
        System.IO.File.WriteAllText("Test.txt", "")
        Using w As StreamWriter = File.AppendText("lostNumbers.txt")
            w.WriteLine(cardNumber)
        End Using
        Return 0
    End Function

    Public Function Search(ByVal firstChar As String, ByVal typeOfEnter As Integer)

        SendKeys.SendWait("^{f}")
        Thread.Sleep(sleep2)
        SendKeys.SendWait(firstChar)
        Thread.Sleep(sleep2)
        SendKeys.SendWait("{ESC}")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("+{TAB}")
        Thread.Sleep(sleep1)
        If (typeOfEnter = 0) Then
            SendKeys.SendWait("{TAB}")
            Thread.Sleep(sleep1)
            SendKeys.SendWait("^{ENTER}")
            Thread.Sleep(sleep4)
        ElseIf (typeOfEnter = 1) Then
            SendKeys.SendWait("^{ENTER}")
            Thread.Sleep(sleep4)
        ElseIf (typeOfEnter = 2) Then
            SendKeys.SendWait("{ENTER}")
            Thread.Sleep(sleep4)
        ElseIf (typeOfEnter = -1) Then
            SendKeys.SendWait("+{TAB}")
            Thread.Sleep(sleep1)
        ElseIf (typeOfEnter = 3) Then
            SendKeys.SendWait("{TAB}")
            Thread.Sleep(sleep1)
        End If

    End Function

    Public Function CopyAndPasteDataOnPage()
        System.IO.File.WriteAllText("Test.txt", "")
        SendKeys.SendWait("^{f}")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("cable")
        Thread.Sleep(sleep1)
        SendKeys.SendWait("{ESC}")
        Thread.Sleep(sleep1)
        SendKeys.SendWait("^{a}")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("^{c}")
        Thread.Sleep(sleep2)
        b.StartInfo.FileName = "Test.txt"
        b.Start()
        Thread.Sleep(sleep3)
        SendKeys.SendWait("^{v}")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("^{s}")
        b.Kill()
        Thread.Sleep(sleep3)
    End Function

    Public Function Login()
        a.Start()
        Thread.Sleep(7000)
        SendKeys.SendWait("{TAB}")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("{ENTER}")
        Thread.Sleep(sleep4)
        SendKeys.SendWait("{TAB}")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("h")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("h")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("{TAB}")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("dis_h2p")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("{TAB}")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("194314456")
        Thread.Sleep(sleep2)
        SendKeys.SendWait("{ENTER}")
        Thread.Sleep(sleep4)

    End Function

    Public Function WriteInExcel(ByVal fileNumber As Integer, ByVal cardNumber As String)
        Try
            count = count + 1
            Dim check As Boolean = False
            Dim fileName As String = ""
            If fileNumber = 1 Then
                fileName = f1
            ElseIf fileNumber = 2 Then
                fileName = f2
            ElseIf fileNumber = 3 Then
                fileName = f3
            End If
            workbook = APP.Workbooks.Open(fileName)
            worksheet = workbook.Worksheets("sheet1")
            Dim cellCount As Integer = 1
            Dim testCell As String = worksheet.Cells(1, 1).Value
            Do While Not (String.IsNullOrEmpty(testCell))
                cellCount = cellCount + 1
                testCell = worksheet.Cells(cellCount, 1).Value
            Loop
            worksheet.Cells(cellCount, 1).Value = cardNumber
            Dim place As String = " "
            If fileNumber = 2 Or fileNumber = 3 Then
                FileOpen(1, "Test.txt", OpenMode.Input)
                Dim line As String
                Dim myData As New ArrayList()
                Do While Not EOF(1)
                    line = LineInput(1)
                    If (line.StartsWith("Name")) Then
                        check = True
                        Dim splitArray() As String = Split(line)
                        Dim name As String = ""
                        For i As Integer = 1 To splitArray.Length - 1
                            If splitArray(i).StartsWith("Care") Then
                                myData.Add(name)
                                Exit For
                            Else
                                name = name + splitArray(i) + " "
                            End If
                        Next
                    ElseIf (line.StartsWith("Big")) Or (line.StartsWith("Work")) Or (line.StartsWith("Fax2")) Then
                        check = True
                        Dim splitArray() As String = Split(line)
                        If (splitArray(splitArray.Length - 2).StartsWith("Phone") Or splitArray(splitArray.Length - 2).StartsWith("Mobile/SMS") Or splitArray(splitArray.Length - 2).StartsWith("Box")) Then
                            myData.Add(" ")
                        Else
                            myData.Add(splitArray(splitArray.Length - 2))
                        End If
                        If (line.StartsWith("Work")) Then
                            myData.Add(splitArray(2))
                        End If
                    ElseIf (line.StartsWith("Payment")) Then
                        check = True
                        Dim splitArray() As String = Split(line)
                        Dim checkPlace = False
                        For i As Integer = 1 To splitArray.Length - 1
                            If (checkPlace) Then
                                place = place + splitArray(i) + " "
                            End If
                            If splitArray(i).StartsWith("Branch") Then
                                checkPlace = True
                            End If
                        Next
                    ElseIf (line.StartsWith("Product")) Then
                        check = True
                        line = LineInput(1)
                        Dim package As String = ""
                        Dim myDate As String = ""
                        Dim currentDay As Integer = 1
                        Dim currentMonth As Integer = 1
                        Dim currentYear As Integer = 1900
                        Dim latestPackage As String = " "
                        Do While Not line.StartsWith("   Subscriber Offers")
                            Dim splitArray() As String = Split(line)
                            Dim checkDate As Boolean = True
                            package = ""
                            For i As Integer = 0 To splitArray.Length - 1
                                If splitArray(i).Equals("D") Or splitArray(i).Equals("A") Then
                                    Dim splitArray2() As String = Split(splitArray(i + 2), "\")
                                    If Not splitArray2.Length - 1 = 2 Then
                                        splitArray2 = Split(splitArray(i + 2), "/")
                                        If Not splitArray2.Length - 1 = 2 Then
                                            checkDate = False
                                            myData.Add(splitArray(i + 2))
                                        End If
                                    End If
                                    If checkDate = True Then
                                        Dim latestDate As Boolean = False
                                        Dim newDay = CInt(splitArray2(0))
                                        Dim newMonth = CInt(splitArray2(1))
                                        Dim newYear = CInt(splitArray2(2))
                                        If (newYear > currentYear) Then
                                            latestDate = True
                                        ElseIf (newYear = currentYear) Then
                                            If (newMonth > currentMonth) Then
                                                latestDate = True
                                            ElseIf (newMonth = currentMonth) Then
                                                If (newDay >= currentDay) Then
                                                    latestDate = True
                                                End If
                                            End If
                                        End If
                                        If latestDate = True Then
                                            currentDay = newDay
                                            currentMonth = newMonth
                                            currentYear = newYear
                                            latestPackage = package
                                            myDate = splitArray2(0) + "-"
                                            If splitArray2(1).Equals("01") Or splitArray2(1).Equals("1") Then
                                                myDate = myDate + "Jan" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("02") Or splitArray2(1).Equals("2") Then
                                                myDate = myDate + "Feb" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("03") Or splitArray2(1).Equals("3") Then
                                                myDate = myDate + "Mar" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("04") Or splitArray2(1).Equals("4") Then
                                                myDate = myDate + "Apr" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("05") Or splitArray2(1).Equals("5") Then
                                                myDate = myDate + "May" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("06") Or splitArray2(1).Equals("6") Then
                                                myDate = myDate + "Jun" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("07") Or splitArray2(1).Equals("7") Then
                                                myDate = myDate + "Jul" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("08") Or splitArray2(1).Equals("8") Then
                                                myDate = myDate + "Aug" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("09") Or splitArray2(1).Equals("9") Then
                                                myDate = myDate + "Sep" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("10") Then
                                                myDate = myDate + "Oct" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("11") Then
                                                myDate = myDate + "Nov" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("12") Then
                                                myDate = myDate + "Dec" + "-" + splitArray2(2)
                                            End If
                                        End If
                                    End If
                                Else
                                    package = package + splitArray(i) + " "
                                End If
                            Next
                            line = LineInput(1)
                        Loop
                        If Not currentYear = 1900 Then
                            myData.Add(latestPackage)
                            myData.Add(myDate)
                        End If
                        Exit Do
                    ElseIf (line.StartsWith("Current Products")) Then
                        check = True
                        line = LineInput(1)
                        Dim package As String = ""
                        Dim myDate As String = ""
                        Dim currentDay As Integer = 1
                        Dim currentMonth As Integer = 1
                        Dim currentYear As Integer = 1900
                        Dim latestPackage As String = " "
                        Do While Not line.StartsWith("Current Installments")
                            Dim splitArray() As String = Split(line)
                            Dim checkDate As Boolean = True
                            package = ""
                            For i As Integer = 0 To splitArray.Length - 1
                                If splitArray(i).Equals("D") Or splitArray(i).Equals("A") Then
                                    Dim splitArray2() As String = Split(splitArray(i + 2), "\")
                                    If Not splitArray2.Length - 1 = 2 Then
                                        splitArray2 = Split(splitArray(i + 2), "/")
                                        If Not splitArray2.Length - 1 = 2 Then
                                            checkDate = False
                                            myData.Add(splitArray(i + 2))
                                        End If
                                    End If
                                    If checkDate = True Then
                                        Dim latestDate As Boolean = False
                                        Dim newDay = CInt(splitArray2(0))
                                        Dim newMonth = CInt(splitArray2(1))
                                        Dim newYear = CInt(splitArray2(2))
                                        If (newYear > currentYear) Then
                                            latestDate = True
                                        ElseIf (newYear = currentYear) Then
                                            If (newMonth > currentMonth) Then
                                                latestDate = True
                                            ElseIf (newMonth = currentMonth) Then
                                                If (newDay >= currentDay) Then
                                                    latestDate = True
                                                End If
                                            End If
                                        End If
                                        If latestDate = True Then
                                            currentDay = newDay
                                            currentMonth = newMonth
                                            currentYear = newYear
                                            latestPackage = package
                                            myDate = splitArray2(0) + "-"
                                            If splitArray2(1).Equals("01") Or splitArray2(1).Equals("1") Then
                                                myDate = myDate + "Jan" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("02") Or splitArray2(1).Equals("2") Then
                                                myDate = myDate + "Feb" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("03") Or splitArray2(1).Equals("3") Then
                                                myDate = myDate + "Mar" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("04") Or splitArray2(1).Equals("4") Then
                                                myDate = myDate + "Apr" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("05") Or splitArray2(1).Equals("5") Then
                                                myDate = myDate + "May" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("06") Or splitArray2(1).Equals("6") Then
                                                myDate = myDate + "Jun" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("07") Or splitArray2(1).Equals("7") Then
                                                myDate = myDate + "Jul" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("08") Or splitArray2(1).Equals("8") Then
                                                myDate = myDate + "Aug" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("09") Or splitArray2(1).Equals("9") Then
                                                myDate = myDate + "Sep" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("10") Then
                                                myDate = myDate + "Oct" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("11") Then
                                                myDate = myDate + "Nov" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("12") Then
                                                myDate = myDate + "Dec" + "-" + splitArray2(2)
                                            End If
                                        End If
                                    End If
                                Else
                                    package = package + splitArray(i) + " "
                                End If
                            Next
                            line = LineInput(1)
                        Loop
                        If Not currentYear = 1900 Then
                            myData.Add(latestPackage)
                            myData.Add(myDate)
                        End If
                        Exit Do
                    End If
                Loop
                myData.Add(place)
                For i As Integer = 0 To myData.Count - 2
                    Dim val As String = myData(i)
                    worksheet.Cells(cellCount, i + 2).Value = myData(i)
                Next
                worksheet.Cells(cellCount, 12).Value = myData(myData.Count - 1)
                FileClose(1)
            End If

            If fileNumber = 2 Or fileNumber = 3 Then
                If check = False Then
                    Using w As StreamWriter = File.AppendText("lostNumbers.txt")
                        w.WriteLine(cardNumber)
                        worksheet.Cells(cellCount, 1).Value = ""
                    End Using
                End If
            End If
            workbook.Save()
            workbook.Close()
            APP.Quit()
            'If fileNumber = 2 Or fileNumber = 3 Then
            '    transMonitor(cardNumber)
            'End If
            'Search("home", 0)
        Catch ex As Exception
            workbook.Save()
            workbook.Close()
            APP.Quit()
            'If fileNumber = 2 Or fileNumber = 3 Then
            '    transMonitor(cardNumber)
            'End If
            'Search("home", 0)
        End Try
    End Function

    Public Function transMonitor(ByVal cardNumber As String)
        Try
            Search("trans monitor", 0)
            Search("From date", 3)
            SendKeys.SendWait("1/1/1990")
            Thread.Sleep(sleep1)
            SendKeys.SendWait("{TAB}")
            Thread.Sleep(sleep1)
            Dim start As String = String.Format(Today.Day & "/" & Today.Month & "/" & Today.Year)
            SendKeys.SendWait(start)
            Thread.Sleep(sleep1)
            SendKeys.SendWait("{TAB}")
            Thread.Sleep(sleep1)
            SendKeys.SendWait(cardNumber)
            Thread.Sleep(sleep1)
            SendKeys.SendWait("{TAB}")
            Thread.Sleep(sleep1)
            SendKeys.SendWait("{TAB}")
            Thread.Sleep(sleep1)
            SendKeys.SendWait("{ENTER}")
            Thread.Sleep(sleep4)
            CopyAndPasteDataOnPage()
            Dim fileName As String = ""
            fileName = f4
            workbook = APP.Workbooks.Open(fileName)
            worksheet = workbook.Worksheets("sheet1")
            Dim cellCount As Integer = 1
            Dim testCell As String = worksheet.Cells(1, 1).Value
            Do While Not (String.IsNullOrEmpty(testCell))
                cellCount = cellCount + 1
                testCell = worksheet.Cells(cellCount, 1).Value
            Loop
            worksheet.Cells(cellCount, 1).Value = cardNumber
            FileOpen(1, "Test.txt", OpenMode.Input)
            Dim line As String
            Dim myData As New ArrayList()
            Do While Not EOF(1)
                line = LineInput(1)
                If (line.StartsWith("Status")) Then
                    line = LineInput(1)
                    Dim amountPaid As String = ""
                    Dim myDate As String = ""
                    Dim currentDay As Integer = 1
                    Dim currentMonth As Integer = 1
                    Dim currentYear As Integer = 1900
                    Dim latestAmount As String = " "
                    Do While Not (line.StartsWith("© Copyright"))
                        If (line.StartsWith(cardNumber)) Then
                            Dim splitArray() As String = Split(line)
                            For i As Integer = 1 To splitArray.Length - 1
                                If (splitArray(i).Equals("Done")) Then
                                    latestAmount = splitArray(i - 1)
                                End If
                                If (splitArray(i).Contains("/") Or splitArray(i).Contains("\")) Then
                                    Dim splitArray2() As String = Split(splitArray(i), "/")
                                    Dim correctDate As Boolean = True
                                    latestAmount = ""
                                    If Not splitArray2.Length - 1 = 2 Then
                                        splitArray2 = Split(splitArray(i), "\")
                                        If Not splitArray2.Length - 1 = 2 Then
                                            myData.Add(splitArray(i))
                                            correctDate = False
                                        End If
                                    End If
                                    If correctDate = True Then
                                        Dim latestDate As Boolean = False
                                        Dim newDay = CInt(splitArray2(0))
                                        Dim newMonth = CInt(splitArray2(1))
                                        Dim newYear = CInt(splitArray2(2))
                                        If (newYear > currentYear) Then
                                            latestDate = True
                                        ElseIf (newYear = currentYear) Then
                                            If (newMonth > currentMonth) Then
                                                latestDate = True
                                            ElseIf (newMonth = currentMonth) Then
                                                If (newDay >= currentDay) Then
                                                    latestDate = True
                                                End If
                                            End If
                                        End If
                                        If (latestDate = True) Then
                                            currentDay = newDay
                                            currentMonth = newMonth
                                            currentYear = newYear
                                            myDate = splitArray2(0) + "-"
                                            If splitArray2(1).Equals("01") Or splitArray2(1).Equals("1") Then
                                                myDate = myDate + "Jan" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("02") Or splitArray2(1).Equals("2") Then
                                                myDate = myDate + "Feb" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("03") Or splitArray2(1).Equals("3") Then
                                                myDate = myDate + "Mar" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("04") Or splitArray2(1).Equals("4") Then
                                                myDate = myDate + "Apr" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("05") Or splitArray2(1).Equals("5") Then
                                                myDate = myDate + "May" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("06") Or splitArray2(1).Equals("6") Then
                                                myDate = myDate + "Jun" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("07") Or splitArray2(1).Equals("7") Then
                                                myDate = myDate + "Jul" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("08") Or splitArray2(1).Equals("8") Then
                                                myDate = myDate + "Aug" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("09") Or splitArray2(1).Equals("9") Then
                                                myDate = myDate + "Sep" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("10") Then
                                                myDate = myDate + "Oct" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("11") Then
                                                myDate = myDate + "Nov" + "-" + splitArray2(2)
                                            ElseIf splitArray2(1).Equals("12") Then
                                                myDate = myDate + "Dec" + "-" + splitArray2(2)
                                            End If
                                        Else
                                            Exit For
                                        End If
                                    End If
                                End If
                            Next
                        End If
                        line = LineInput(1)
                    Loop
                    If Not currentYear = 1900 Then
                        myData.Add(latestAmount)
                        myData.Add(myDate)
                    End If
                End If
            Loop
            FileClose(1)
            For i As Integer = 0 To myData.Count
                worksheet.Cells(cellCount, i + 2).Value = myData(i)
            Next
            workbook.Save()
            workbook.Close()
            APP.Quit()
            Search("home", 0)
        Catch ex As Exception
            workbook.Save()
            workbook.Close()
            APP.Quit()
            Search("home", 0)
        End Try
    End Function

    Private Sub Button5_Click(sender As Object, e As EventArgs) Handles Button5.Click
        Dim form2 = New Form2()
        Me.Hide()
        form2.Show()
    End Sub

    Private Sub Button4_Click_1(sender As Object, e As EventArgs) Handles Button4.Click
        Using ofd As New OpenFileDialog()
            If ofd.ShowDialog() = DialogResult.OK Then
                TextBox2.Text = ofd.FileName
            End If
        End Using
    End Sub

    Public Function createFiles()
        If (Not File.Exists("Test.txt")) Then
            Dim fs As FileStream = File.Create("Test.txt")
            fs.Close()
        End If
        If (Not File.Exists("lostNumbers.txt")) Then
            Dim fs As FileStream = File.Create("lostNumbers.txt")
            fs.Close()
        End If
        If (Not File.Exists("Files.txt")) Then
            Dim fs As FileStream = File.Create("Files.txt")
            fs.Close()
        End If
    End Function

    Public Function checkSpeed()
        'Dim speed As Integer = Int(Me.NumericUpDown1.Value)
        sleep4 = Me.NumericUpDown1.Value * 1000
    End Function

End Class

