# Scrappy

These are a couple of web scrapers made for my own convenience. Each of them extracts all stories published in some of the SFF magazines I follow.


I'd always been curious about what I was missing by not endlessly scrolling through a magazine's back issues. Was there a hidden jewel among them I didn't know about? Had I missed a new story by one of my favourite authors? Would I find a story that could teach me more about structure, character development, or plot?

It's a literary FOMO of sorts.

Fortunately, I'm now able to solve it! Each of these web scrapers is tailor-made for one of the currently active SFF magazines. They're all fairly simple, but they do exactly what I need them to do.

## java/scrappy-jsoup 

### The Dark Magazine

[The Dark Magazine](http://thedarkmagazine.com) is a monthly horror and dark fiction magazine. Here you can find stories that set your teeth on edge without necessarily knowing what is, exactly, making your skin crawl. Each year, several The Dark stories slither in The Best Horror of the Year anthologies and snatch an award or two.

#### The scraper

The scraper itself needs some refactoring. Personally, I don't think the scraper needs to be a separate initialized class. All the scraping methods can just be private static inside the main class. That would make it long, but seeing how it's really simple, and website specific (that is, not reusable for a different website), one long script should do just fine.

## java/scrappy-selenium

### Tor and Strage Horizons magazine

I'm putting ScrapeTor and ScrapeSH on hold for now.

### Lightspeed magazine

[Lightspeed magazine](http://www.lightspeedmagazine.com/) is another monthly SFF magazine. 

#### The scraper

This time, one class (ScrapeLSM) contains all the necessary methods. I still need to make it more neat, more readable and add printing the results in a txt file.

Now, for the process. The only thing that stands out here is the way I chose to iterate throught the page numbers. Since I didn't want to use a Set to gather all the links (I need the stories in chronological order), I wanted to get the stories on one page, go to the next page, get the stories there, etc. 

And seeing how the URL for a page is the same excepting the number, I thought it a good idea to simply get the last page number from the fist page, and just use a loop to go through them. 

What I currently don't like about this scraper is that I used string concatenation inside a loop and the fact that I have a forEach stream nested in a for loop. While the scraper does the job I needed it to do (so I've no reason to use it again), the code can still be improved.

Granted, I didn't *need* Selenium for this at all, but I wanted to use it anyway.

## deprecated

A dumping ground for classes I used for experimentation and practice before writing the scrapers themselves.
