/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    import java.io.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.sound.sampled.*;
/**
 *
 * @author dell
 */
public class Soundplayer extends JComponent {


/**
*
* This class is a Swing component that can load and play a sound clip,
* displaying progress and controls. The main( ) method is a test program.
* This component can play sampled audio or MIDI files, but handles them
* differently. For sampled audio, time is reported in microseconds, tracked in
* milliseconds and displayed in seconds and tenths of seconds. This program
* does no transcoding, so it can only play sound files that use the PCM encoding.
*/

Clip clip; // Contents of a sampled audio file
boolean playing = false; // whether the sound is currently playing

// Length and position of the sound are measured in milliseconds
int audioLength = 1000; // Length of the sound.
int audioPosition = 0; // Current position within the sound

// The following fields are for the GUI
JButton play; // The Play button
JButton stop; // The Stop button
JSlider progress; // Shows and sets current position in sound
JLabel time; // Displays audioPosition as a number
Timer timer; // Updates slider every 100 milliseconds

File filename;
SourceDataLine line = null;
AudioInputStream audioInputStream = null;
PlayerThread pt;

public static void main(String args[]){
         File f= new File("C:/Users/dell/Downloads/file_example_WAV_1MG.wav");
	Soundplayer player;
    try {
        player = new Soundplayer(f);
    } catch (IOException ex) {
        Logger.getLogger(Soundplayer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedAudioFileException ex) {
        Logger.getLogger(Soundplayer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (LineUnavailableException ex) {
        Logger.getLogger(Soundplayer.class.getName()).log(Level.SEVERE, null, ex);
    }
	player.setFile(f);
	player.setVisible(true);
 
}


// Create a SoundPlayer component for the specified file.
public Soundplayer(File f)
throws IOException,
UnsupportedAudioFileException,
LineUnavailableException

{

// Now create the basic GUI
play = new JButton("Play"); // Play button
stop = new JButton("Stop"); // Stop button
progress = new JSlider(0, audioLength, 0); // Shows position in sound
time = new JLabel("0"); // Shows position as a #

play.setEnabled(false);
stop.setEnabled(false);

// When clicked, start playing the sound
play.addActionListener(new ActionListener( ) {
@Override
public void actionPerformed(ActionEvent e) {
if (!playing){
pt = new PlayerThread();
pt.start();
}
}
});

// When clicked, stop playing the sound
stop.addActionListener(new ActionListener( ) {
public void actionPerformed(ActionEvent e) {
if (playing) stop( );
}
});

// Whenever the slider value changes, first update the time label.
// Next, if we're not already at the new position, skip to it.
progress.addChangeListener(new ChangeListener( ) {
@Override
public void stateChanged(ChangeEvent e) {
int value = progress.getValue( );
// Update the time label
time.setText(value/1000 + "." + (value%1000)/100);
// If we're not already there, skip there.
if (value != audioPosition) skip(value);
}
});

// This timer calls the tick( ) method 10 times a second to keep
// our slider in sync with the music.
timer = new javax.swing.Timer(100, new ActionListener( ) {
@Override
public void actionPerformed(ActionEvent e) {
//System.out.println("x");
tick( );
}
});

// put those controls in a row
Box row = Box.createHorizontalBox( );
row.add(play);
row.add(stop);
row.add(progress);
row.add(time);

// And add them to this component.
setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
this.add(row);

}

public void setFile(File f) {

filename = f;

}

class PlayerThread extends Thread {
@Override
public void run() {
float length = 0;
try
{
audioInputStream = AudioSystem.getAudioInputStream(filename);
length = filename.length();
//System.out.println("File length is " + length + " bytes.");
}
catch (Exception e)
{
e.printStackTrace();
}

AudioFormat audioFormat = audioInputStream.getFormat();
int frameSize = audioFormat.getFrameSize();
float frameRate = audioFormat.getFrameRate();
float lengthInSeconds = ((length/frameSize)/frameRate);
audioLength = (int) lengthInSeconds;
audioLength = audioLength * 1000;
progress.setMaximum(audioLength);


DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat, AudioSystem.NOT_SPECIFIED);

timer.start( );

try
{
line = (SourceDataLine) AudioSystem.getLine(info);
line.open(audioFormat);
}
catch (LineUnavailableException e)
{
e.printStackTrace();
System.exit(1);
}
catch (Exception e)
{
e.printStackTrace();
}

playing = true;

line.start();
int nBytesRead = 0;
byte[] abData = new byte[128000];
while (nBytesRead != -1)
{
try
{
nBytesRead = audioInputStream.read(abData, 0, abData.length);
int temp [] = new int[abData.length];
}
catch (IOException e)
{
e.printStackTrace();
}
if (nBytesRead >= 0)
{
int nBytesWritten = line.write(abData, 0, nBytesRead);
}
}

line.drain();
line.close();

}
}

/** Stop playing the sound*/
public void stop( ) {
timer.stop( );
line.stop();
line.flush();
line.close();
pt.interrupt();
pt = null;

playing = false;
}

/** Skip to the specified position */
public void skip(int position) { // Called when user drags the slider
if (position < 0 || position > audioLength) return;
audioPosition = position;
//clip.setMicrosecondPosition(position * 1000);
progress.setValue(position); // in case skip( ) is called from outside
}

// An internal method that updates the progress bar.
// The Timer object calls it 10 times a second.
// If the sound has finished, it resets to the beginning
void tick( ) {
if (playing == true) {
audioPosition = (int)(line.getMicrosecondPosition( )/1000);
progress.setValue(audioPosition);
time.setText(audioPosition/1000 + "." + (audioPosition%1000)/100);
}
}


}
