# Scrappy

These are a couple of web scrapers made for my own convenience. Each of them extracts all stories published in some of the SFF magazines I follow.


I'd always been curious about what I was missing by not endlessly scrolling through a magazine's back issues. Was there a hidden jewel among them I didn't know about? Had I missed a new story by one of my favourite authors? Would I find a story that could teach me more about structure, character development, or plot?

It's a literary FOMO of sorts.

Fortunately, I'm now able to solve it! Each of these web scrapers is tailor-made for one of the currently active SFF magazines. They're all fairly simple, but they do exactly what I need them to do.

## java/scrappy-jsoup : The Dark Magazine

[The Dark Magazine](http://thedarkmagazine.com) is a monthly horror and dark fiction magazine. Here you can find stories that set your teeth on edge without necessarily knowing what is, exactly, making your skin crawl. Each year, several The Dark stories slither in The Best Horror of the Year anthologies and snatch an award or two.

### The scraper

The scraper itself needs some refactoring. Personally, I don't think the scraper needs to be a separate initialized class. All the scraping methods can just be private static inside the main class. That would make it long, but seeing how it's really simple, and website specific (that is, not reusable for a different website), one long script should do just fine.


## java/scrappy-xpath

## java/scrappy-selenium

## deprecated

A dumping ground for classes I used for experimentation and practice before writing the scrapers themselves.
