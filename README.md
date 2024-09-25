# KKLC Lookup
Recently I started studying Kanji with the "Kodansha Kanji Learner's Course" (KKLC) but I felt that searching known kanjis in the book for finding the mnemonics was pretty hard, I also found few tools on the internet for getting the KKLC index from a kanji that i found.

So I wanted to make a simple but handy tool for MYSELF with that purpose, I also wanted to do it on Java (even when it would be better to make a htlm5 app) in order to practice the language.

# How it works

Simply each time you encounter a kanji that you think you have studied but don't recall the mnemonics, just copy to clipboard and paste in the search bar (you can also paste multiple kanji or even a whole sentence) and you will see, for each kanji searched which appears in the book, the meanings of the kanji as well as their number from the order in which kanji appear in the book.

# Concerns

I'm sharing this app but in reality is more for personal use, I'll provide both a jar file and a Windows portable exec bundled with the openjdk runtime. If anyone had the exact same problem as me, great, but I'm not planing to make a fully featured kanji dictionary or anything like that. However, I'm planning to add also RTK indexes desipte these being much more common in dictionaries like jisho.org.

The program was compilled with openjdk17 and may not run on previous runtimes of java, for that I've bundled it with the runtime but just for windows, for other platforms check the jar file.
