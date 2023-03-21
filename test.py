from fpdf import FPDF
from os import path


def files_to_pdf(files: list, line_wrap: int = 80, out_filename: str = path.basename(f"{__file__}.pdf".replace(".py", ""))):
    """
    Puts the text content of multiple files into a PDF with:

    - Individual line numbers
    - Titles dictating the file name.
    - Line wrap

    # Inputs
    - files : list
        - A list of file paths to be included
    - line_wrap : int, defualt = 80
        - Line wrap location
    - out_filename : str, default = python file name.pdf
        - Output file name
    """

    pdf = FPDF(orientation='P', unit='mm', format='A4')
    pdf.set_auto_page_break(True, margin=10)
    pdf.add_page()
    pdf.set_font(family='Courier', size=8)

    for file_path in files:
        with open(file_path, "rb") as f:
            text = f.read().decode("latin-1").split("\n")

        pdf.ln(5)
        pdf.cell(0, 10, file_path, 1, 5, 'C')  # Title

        line_count = 1

        # The length of the number of lines.
        num_lines_len = len(str(len(text)))
        # e.g. num lines = 123
        # num_lines_len = 3

        for line in text:
            for i in range(1, (len(line)//line_wrap)+1):  # i = Which line wrap it is on
                line_wrap_word = prev_word_loc(line, (line_wrap) * i)
                # Location to wrap the word

                line = line[:line_wrap_word] + "\n" + line[line_wrap_word:]

            sub_lines = line.split("\n")
            spaces = " " * (num_lines_len - len(str(line_count)))
            # First sub_line with numbers
            pdf.cell(0, 4, f"{line_count}{spaces} |  {sub_lines[0]}", ln=1)

            for sub_line in sub_lines[1:]:  # Other sub lines with no numbers
                pdf.cell(
                    0, 4, f"{num_lines_len*' '} |  {sub_line}", ln=1)
                # The number of spaces still can mess up if there are LOADS of lines going over
                # But it is still readable so who cares

            line_count += 1

    pdf.output(out_filename, "F")


def prev_word_loc(line: str, location: int, max: int = 10) -> int:
    """
    Reverse searches <line> to find the first space before <location>.
    Will stop searching after <max> chars.

    # Inputs
    - line : str
    - location : int
    - max : int, default = 10
        - If -1 then max is ignored

    # Output
    - Location of previous word or location if failed search
    """

    steps = 0
    # Searches backwards from location to find the first " "
    for char in line[location::-1]:
        if char == " " and steps <= max:
            return location - steps
        elif steps > max and max != -1:
            return location

        steps += 1

    # If it is here than it never found a " "
    return location


files_to_pdf(
    ["test.txt", "example_code/Interaction.java", "example_code/Post.java", "example_code/Comment.java"], line_wrap=100)
