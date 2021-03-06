/*
 * Copyright 2015 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package science.atlarge.graphalytics.graphmat.algorithms.bfs;

import science.atlarge.graphalytics.domain.algorithms.BreadthFirstSearchParameters;
import science.atlarge.graphalytics.graphmat.GraphmatJob;

import org.apache.commons.configuration.Configuration;

import it.unimi.dsi.fastutil.longs.Long2LongMap;

import java.util.List;

/**
 * Breadth-first search job implementation for GraphMat. This class is responsible for formatting BFS-specific
 * arguments to be passed to the GraphMat executable, and does not include the implementation of the algorithm.
 *
 * @author Yong Guo
 * @author Tim Hegeman
 */
public final class BreadthFirstSearchJob extends GraphmatJob {

	private final BreadthFirstSearchParameters params;

	public BreadthFirstSearchJob(Configuration config, String graphPath, Long2LongMap vertexTranslation, BreadthFirstSearchParameters params, String jobId) {
		super(config, graphPath, vertexTranslation, jobId);
		this.params = params;
	}

	@Override
	protected String getExecutable() {
		return "bfs";
	}

	@Override
	protected void addJobArguments(List<String> args) {
		long oldSource = params.getSourceVertex();
		long newSource = vertexTranslation.get(oldSource);
		
		args.add(Long.toString(newSource));
		args.add(jobId);
	}
}
