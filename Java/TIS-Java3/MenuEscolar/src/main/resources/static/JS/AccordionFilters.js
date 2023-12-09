function toggleAccordion(index) {
    for (let i = 1; i <= 7; i++) {
        const content = document.getElementById(`content${i}`);
        if (i === index) {
          content.style.display = content.style.display === 'none' ? 'block' : 'none';
        } else {
          content.style.display = 'none';
        }
    }
}
function stopPropagation(event) {
    event.stopPropagation();
}