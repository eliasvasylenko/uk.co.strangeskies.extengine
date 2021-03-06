package uk.co.strangeskies.extengine.sections.test;

import org.junit.Assert;
import org.junit.Test;

import uk.co.strangeskies.extengine.sections.Section;
import uk.co.strangeskies.extengine.sections.SectionProcessingContext;
import uk.co.strangeskies.extengine.sections.SectionProcessor;
import uk.co.strangeskies.extengine.sections.impl.SectionProcessorImpl;

public class SectionTest {
	@Test
	public void testStack() {
		final StringBuilder result = new StringBuilder();

		SectionProcessor processor = new SectionProcessorImpl();
		processor.process(new StackingSection(3, result));

		Assert.assertEquals(result.toString(),
				"[3 3h[2 2h[1 1h[0 0]r1 1]r2 2]r3 3]");
	}
}

class StackingSection implements Section {
	private final int size;
	private final StringBuilder result;

	public StackingSection(int size, StringBuilder result) {
		this.size = size;
		this.result = result;
	}

	@Override
	public void enter(SectionProcessingContext context) {
		result.append("[" + size + " ");
		if (size > 0) {
			context.haltAndProcess(new StackingSection(size - 1, result));
		}
		result.append(size + "]");
	}

	@Override
	public void halt() {
		result.append(size + "h");
	}

	@Override
	public void resume() {
		result.append("r" + size + " ");
	}
}
