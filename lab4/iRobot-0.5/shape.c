/*******************************************************************************
 * simple.c
 *
 * A simple iRobot program to demo in lab3.
 * Plays a few songs while crashing into things.
 * Re-written by kwalsh@cs.holycross.edu, based on original simple.c.
 *******************************************************************************/
#include "iRobot.h"

// Notes for bump song
uint8_t bump_notes[] = {71, 67}; // B, G
uint8_t bump_times[] = {24,  8}; // three-eighth, one-eighth
uint8_t bump_count = 2; // two notes

// Notes for button song (theme from deliverance)
uint8_t del_notes[] = {59, 60, 62, 59, 60, 57, 59, 55, 57, 50, 55, 55, 57, 59, 55, 59, 57};
uint8_t del_times[] = {16, 16,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8,  8};
uint8_t del_count = 17; // seventeen notes (takes up 2 song slots)

// Notes for the ending finale song
uint8_t end_notes[] = {71, 69, 67, 65, 64, 62, 60}; // descending scale
uint8_t end_times[] = { 8,  8,  8,  8,  8,  8, 16};
uint8_t end_count = 7; // seven notes

int main(void)
{
    // start the body if needed
    WakeRobot();

    // define some songs
    DefineSong(1, bump_count, bump_notes, bump_times);
    DefineSong(2, del_count, del_notes, del_times); // also takes up song slot 3
    DefineSong(4, end_count, end_notes, end_times);

    // wait for button, then play the song from deliverance
    WaitForBlackButton();
    PlaySong(2);

    bool ok;
    ok = Straight(1000); // distances are in millimeters

    // if we stopped because of a bump, play the bump song and try once more
    if (!ok) {
        // play a song, spin around once, back up, then try again
        PlaySong(1);
        Turn(360);
        Straight(-200); // 200 mm is 20 cm
        // The constant FOOT is defined to be 304, so 3*FOOT works out to 912 mm,
        // which is about 3 feet. There are also similar constants for METER,
        // CENTIMETER, INCH, etc., or you can just do everything in mm.
        Straight(3*FOOT);
    }

    // play the end song and quit
    PlaySong(4);
}



