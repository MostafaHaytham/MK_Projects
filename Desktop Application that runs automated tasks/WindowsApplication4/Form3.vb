Public Class Form3


    Private Sub Button4_Click(sender As Object, e As EventArgs) Handles Button4.Click

        If String.IsNullOrEmpty(TextBox1.Text) Then
            MsgBox("You Must Enter the password!")
        ElseIf TextBox1.Text.Equals("117155") Then
            Dim form1 = New Form1()
            Me.Hide()
            form1.Show()
        Else
            MsgBox("Wrong Password!")
            TextBox1.Text = ""
        End If
    End Sub


End Class